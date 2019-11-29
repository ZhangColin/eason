<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <el-button type="primary" @click="handleAdd()">新增</el-button>
    </el-card>
    <el-table
      v-loading="listLoading"
      :data="list"
      class="table-container"
      element-loading-text="加载中..."
      stripe
      border
      fit
      highlight-current-row
      size="small"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" align="center" />
      <el-table-column align="left" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="类型名称" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="属性数量" align="left">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="toSpecificationList(scope.$index, scope.row)"
          >{{ scope.row.specificationCount }}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="参数数量" align="left">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="toParamList(scope.$index, scope.row)"
          >{{ scope.row.paramCount }}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="200">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
          >编辑
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :current-page.sync="page.currentPage"
      :page-sizes="[5, 10, 20]"
      :page-size="page.pageSize"
      :total="page.total"
      class="pagination-container"
      background
      align="right"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
    >
      <el-form ref="productAttributeCategoryForm" :model="productAttributeCategory" :rules="rules" label-width="120px">
        <el-form-item label="类型名称">
          <el-input v-model="productAttributeCategory.name" auto-complete="off" />
        </el-form-item>
      </el-form>
      <span slot="footer">
        <el-button @click="dialogVisible=false">取消</el-button>
        <el-button type="primary" @click="handleConfirm()">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { searchProductAttributeCategories, addProductAttributeCategory, editProductAttributeCategory, removeProductAttributeCategory } from '@/api/goods/productAttributeCategoryApi'

export default {
  name: 'ProductAttributeCategory',
  data() {
    return {
      list: null,
      listLoading: true,
      multipleSelection: [],
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 10
      },
      dialogVisible: false,
      dialogTitle: '',
      productAttributeCategory: {
        name: '',
        id: 0
      },
      rules: {
        name: [
          { required: true, message: '请输入类型名称', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      searchProductAttributeCategories(this.page.currentPage, this.page.pageSize).then(response => {
        this.list = response.data.rows
        this.page.total = response.data.total
        this.listLoading = false
      })
    },
    handleSizeChange(pageSize) {
      this.page.currentPage = 1
      this.page.pageSize = pageSize
      this.fetchData()
    },
    handleCurrentChange(currentPage) {
      this.page.currentPage = currentPage
      this.fetchData()
    },
    handleSelectionChange(val) {
      this.mu = val
    },
    handleAdd() {
      this.productAttributeCategory = { id: 0, name: '' }
      this.dialogTitle = '添加类型'
      this.dialogVisible = true
    },
    handleEdit(index, row) {
      this.productAttributeCategory = { id: row.id, name: row.name }
      this.dialogTitle = '编辑类型'
      this.dialogVisible = true
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该类型', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeProductAttributeCategory(row.id).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success',
            duration: 1000
          })
          this.fetchData()
        })
      })
    },
    handleConfirm() {
      this.$refs['productAttributeCategoryForm'].validate((valid) => {
        if (valid) {
          if (this.dialogTitle === '添加类型') {
            addProductAttributeCategory(this.productAttributeCategory.name).then(response => {
              this.$message({
                message: '添加成功',
                type: 'success',
                duration: 1000
              })
              this.dialogVisible = false
              this.fetchData()
            })
          } else {
            editProductAttributeCategory(this.productAttributeCategory.id, this.productAttributeCategory.name).then(response => {
              this.$message({
                message: '修改成功',
                type: 'success',
                duration: 1000
              })
              this.dialogVisible = false
              this.fetchData()
            })
          }
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
    toSpecificationList(index, row) {
      this.$router.push({ path: '/goods/attributes/productAttributes',
        query: { categoryId: row.id, categoryName: row.name, type: 0 }})
    },
    toParamList(index, row) {
      this.$router.push({ path: '/goods/attributes/productAttributes',
        query: { categoryId: row.id, categoryName: row.name, type: 1 }})
    }
  }
}
</script>
