<template>
  <div class="app-container">
    <el-card shadow="never">
      <el-form ref="productCategoryForm" :model="productCategory" :rules="rules" label-width="150px">
        <el-form-item label="分类名称：">
          <el-input v-model="productCategory.name" />
        </el-form-item>
        <el-form-item label="上级分类：">
          <el-select v-model="productCategory.parentId" placeholder="请选择分类">
            <el-option v-for="item in productCategoryOptions" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="数量单位：">
          <el-input v-model="productCategory.productUnit" />
        </el-form-item>
        <el-form-item label="显示在导航栏：">
          <el-radio-group v-model="productCategory.showNavigation">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="显示：">
          <el-radio-group v-model="productCategory.isShow">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="图标：">
          <el-input v-model="productCategory.icon" />
        </el-form-item>
        <el-form-item label="关键字：">
          <el-input v-model="productCategory.keywords" />
        </el-form-item>
        <el-form-item label="描述：">
          <el-input v-model="productCategory.description" />
        </el-form-item>
        <el-form-item label="排序：">
          <el-input v-model.number="productCategory.sort" />
        </el-form-item>
        <el-form-item
          v-for="(productAttribute, index) in productAttributes"
          :key="productAttribute.key"
          :label="index | filterLabel"
        >
          <el-cascader
            v-model="productAttribute.value"
            :options="attributeOptions"
            expand-trigger="hover"
            clearable
          />
          <el-button @click.prevent="removeProductAttribute(productAttribute)">删除</el-button>
        </el-form-item>
        <el-form-item>
          <el-button size="small" type="primary" @click="addProductAttribute()">新增</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleSubmit()">提交</el-button>
          <el-button @click="handleReset()">重置</el-button>
          <el-button @click="handleBack()">返回</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { getProductCategory, addProductCategory, editProductCategory, getProductCategoryAttributes, getProductCategoriesByLevel } from '@/api/goods/productCategoryApi'
import { findAllParams } from '@/api/goods/productAttributeCategoryApi'

const defaultProductCategory = {
  name: '',
  parentId: 0,
  productUnit: '',
  showNavigation: false,
  isShow: false,
  icon: '',
  keywords: '',
  description: '',
  attributeIds: [],
  sort: 0
}

export default {
  name: 'ProductCategoryFrom',
  filters: {
    filterLabel(index) {
      if (index === 0) {
        return '筛选属性：'
      } else {
        return ''
      }
    }
  },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      productCategory: Object.assign({}, defaultProductCategory),
      rules: {
        name: [
          { required: true, message: '请输入分类名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ],
        sort: [
          { type: 'number', message: '排序必须为数字' }
        ]
      },
      productCategoryOptions: [],
      attributeOptions: [],
      productAttributes: []
    }
  },
  created() {
    this.init()
    this.initTopLevelProductCategories()
    this.initAttributeOptions()
  },
  methods: {
    init() {
      if (this.isEdit) {
        getProductCategory(this.$route.query.id).then(response => {
          this.productCategory = response.data
        })
        getProductCategoryAttributes(this.$route.query.id).then(response => {
          this.productAttributes = []
          for (let i = 0; i < response.data.length; i++) {
            this.productAttributes.push({
              key: Date.now() + i,
              value: [response.data[i].attributeCategoryId, response.data[i].attributeId]
            })
          }
          if (this.productAttributes.length === 0) {
            this.productAttributes.push({
              value: null,
              key: Date.now()
            })
          }
        })
      } else {
        this.productCategory = Object.assign({}, defaultProductCategory)
        this.productAttributes.push({
          value: null,
          key: Date.now()
        })
      }
    },
    initTopLevelProductCategories() {
      getProductCategoriesByLevel(0).then(response => {
        this.productCategoryOptions = response.data
        this.productCategoryOptions.unshift({ id: 0, name: '无上级分类' })
      })
    },
    initAttributeOptions() {
      findAllParams().then(response => {
        const list = response.data
        for (let i = 0; i < list.length; i++) {
          const attributeCategory = list[i]
          const children = []
          for (let j = 0; j < attributeCategory.attributes.length; j++) {
            children.push({
              label: attributeCategory.attributes[j].attributeName,
              value: attributeCategory.attributes[j].attributeId
            })
          }

          this.attributeOptions.push({
            label: attributeCategory.attributeCategoryName,
            value: attributeCategory.attributeCategoryId,
            children: children
          })
        }
      })
    },
    getSelectedAttributeIds() {
      const attributeIds = []

      for (let i = 0; i < this.productAttributes.length; i++) {
        const item = this.productAttributes[i]
        if (item.value != null && item.value.length === 2) {
          attributeIds.push(item.value[1])
        }
      }

      return attributeIds
    },
    handleSubmit() {
      this.$refs['productCategoryForm'].validate(valid => {
        if (valid) {
          this.$confirm('是否提交数据', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.productCategory.attributeIds = this.getSelectedAttributeIds()
            if (this.isEdit) {
              editProductCategory(this.$route.query.id, this.productCategory).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                })
                this.$router.back()
              })
            } else {
              addProductCategory(this.productCategory).then(response => {
                this.init()
                this.$message({
                  message: '提交成功',
                  type: 'success',
                  duration: 1000
                })
                this.$router.back()
              })
            }
          })
        } else {
          this.$message({
            message: '验证失败',
            type: 'error',
            duration: 1000
          })
          return false
        }
      })
    },
    removeProductAttribute(productAttribute) {
      if (this.productAttributes.length === 1) {
        this.$message({
          message: '至少要留一个',
          type: 'warning',
          duration: 1000
        })
        return
      }
      var index = this.productAttributes.indexOf(productAttribute)
      if (index !== -1) {
        this.productAttributes.splice(index, 1)
      }
    },
    addProductAttribute() {
      if (this.productAttributes.length === 3) {
        this.$message({
          message: '最多添加三个',
          type: 'warning',
          duration: 1000
        })
        return
      }
      this.productAttributes.push({
        value: null,
        key: Date.now()
      })
    },
    handleReset() {
      this.init()
    },
    handleBack() {
      this.$router.back()
    }
  }
}
</script>
