<template>
  <div class="app-container">
    <el-card shadow="never">
      <el-form ref="brandForm" :model="brand" :rules="rules" label-width="150px">
        <el-form-item label="名称：">
          <el-input v-model="brand.name" />
        </el-form-item>
        <el-form-item label="首字母：">
          <el-input v-model="brand.firstLetter" />
        </el-form-item>
        <el-form-item label="制造商：">
          <el-radio-group v-model="brand.isManufacturer">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="显示：">
          <el-radio-group v-model="brand.isShow">
            <el-radio :label="true">是</el-radio>
            <el-radio :label="false">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="logo：">
          <el-input v-model="brand.logo" />
        </el-form-item>
        <el-form-item label="专区大图：">
          <el-input v-model="brand.bigPic" />
        </el-form-item>
        <el-form-item label="排序：">
          <el-input v-model.number="brand.sort" />
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
import { getBrand, addBrand, editBrand } from '@/api/goods/brandApi'

const defaultBrand = {
  name: '',
  firstLetter: '',
  isManufacturer: false,
  isShow: false,
  logo: '',
  bigPic: '',
  sort: 0
}

export default {
  name: 'BrandFrom',
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      brand: Object.assign({}, defaultBrand),
      rules: {
        name: [
          { required: true, message: '请输入品牌名称', trigger: 'blur' },
          { min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur' }
        ],
        logo: [
          { required: true, message: '请输入品牌logo', trigger: 'blur' }
        ],
        sort: [
          { type: 'number', message: '排序必须为数字' }
        ]
      }
    }
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      if (this.isEdit) {
        getBrand(this.$route.query.id).then(response => {
          this.brand = response.data
        })
      } else {
        this.brand = Object.assign({}, defaultBrand)
      }
    },
    handleSubmit() {
      this.$refs['brandForm'].validate(valid => {
        if (valid) {
          this.$confirm('是否提交数据', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (this.isEdit) {
              editBrand(this.$route.query.id, this.brand).then(response => {
                this.$message({
                  message: '修改成功',
                  type: 'success',
                  duration: 1000
                })
                this.$router.back()
              })
            } else {
              addBrand(this.brand).then(response => {
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
