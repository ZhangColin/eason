<template>
  <div class="app-container">
    <el-card shadow="never">
      <el-form ref="productAttributeForm" :model="productAttribute" :rules="rules" label-width="150px">
        <el-form-item label="属性名称：">
          <el-input v-model="productAttribute.name" />
        </el-form-item>
        <el-form-item label="商品类型：">
          <el-select v-model="productAttribute.categoryId" placeholder="请选择">
            <el-option
              v-for="item in productAttributeCategories"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="属性是否可选：">
          <el-radio-group v-model="productAttribute.selectType">
            <el-radio :label="0">唯一</el-radio>
            <el-radio :label="1">单选</el-radio>
            <el-radio :label="2">复选</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="属性值的录入方式：">
          <el-radio-group v-model="productAttribute.inputType">
            <el-radio :label="0">手工录入</el-radio>
            <el-radio :label="1">从下面列表中选择</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="属性值可选值列表：">
          <el-input v-model="inputListFormat" :autosize="true" type="textarea" />
        </el-form-item>
        <el-form-item label="分类筛选样式：">
          <el-radio-group v-model="productAttribute.filterType">
            <el-radio :label="0">普通</el-radio>
            <el-radio :label="1">颜色</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="能否进行检索：">
          <el-radio-group v-model="productAttribute.searchType">
            <el-radio :label="0">不需要检索</el-radio>
            <el-radio :label="1">关键字检索</el-radio>
            <el-radio :label="2">范围检索</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="商品属性关联：">
          <el-radio-group v-model="productAttribute.related">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否支持手动新增：">
          <el-radio-group v-model="productAttribute.handAdd">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="排序：">
          <el-input v-model.number="productAttribute.sort" />
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
import { getProductAttribute, addProductAttribute, editProductAttribute } from '@/api/goods/productAttributeApi'
import { getAllProductAttributeCategories } from '@/api/goods/productAttributeCategoryApi'

const defaultProductAttribute = {
  name: '',
  categoryId: 0,
  selectType: 0,
  inputType: 0,
  inputList: '',
  filterType: 0,
  searchType: 0,
  related: false,
  handAdd: false,
  type: 0,
  sort: 0
}

export default {
  name: 'ProductAttributeFrom',
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      productAttribute: Object.assign({}, defaultProductAttribute),
      rules: {
        name: [
          { required: true, message: '请输入属性名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ]
      },
      productAttributeCategories: null,
      inputListFormat: null
    }
  },
  watch: {
    inputListFormat: function(newValue, oldValue) {
      newValue = newValue.replace(/\n/g, ',')
      this.productAttribute.inputList = newValue
    }
  },
  created() {
    this.init()
    this.fetchCategories()
  },
  methods: {
    init() {
      if (this.isEdit) {
        getProductAttribute(this.$route.query.id).then(response => {
          this.productAttribute = response.data
          this.inputListFormat = this.productAttribute.inputList.replace(/,/g, '\n')
        })
      } else {
        this.productAttribute = Object.assign({}, defaultProductAttribute)
      }
      this.productAttribute.categoryId = Number(this.$route.query.categoryId)
      this.productAttribute.type = Number(this.$route.query.type)
    },
    fetchCategories() {
      getAllProductAttributeCategories().then(response => {
        this.productAttributeCategories = response.data
      })
    },
    handleSubmit() {
      this.$refs['productAttributeForm'].validate(valid => {
        if (valid) {
          this.$confirm('是否提交数据', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (this.isEdit) {
              editProductAttribute(this.$route.query.id, this.productAttribute).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                })
                this.$router.back()
              })
            } else {
              addProductAttribute(this.productAttribute).then(response => {
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
    handleReset() {
      this.init()
    },
    handleBack() {
      this.$router.back()
    }
  }
}
</script>
