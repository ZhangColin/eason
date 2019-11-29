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
      <el-table-column label="属性名称" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="商品类型" align="left">
        <template>
          {{ $route.query.categoryName }}
        </template>
      </el-table-column>
      <el-table-column label="属性是否可选" align="left">
        <template slot-scope="scope">
          {{ scope.row.selectType | selectTypeFilter }}
        </template>
      </el-table-column>
      <el-table-column label="属性值的录入方式" align="left">
        <template slot-scope="scope">
          {{ scope.row.inputType | inputTypeFilter }}
        </template>
      </el-table-column>
      <el-table-column label="可选值列表" align="left">
        <template slot-scope="scope">
          {{ scope.row.inputList }}
        </template>
      </el-table-column>
      <el-table-column label="排序" align="left">
        <template slot-scope="scope">
          {{ scope.row.sort }}
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
  </div>
</template>

<script>
import { searchProductAttributes, removeProductAttribute } from '@/api/goods/productAttributeApi'

export default {
  name: 'ProductAttribute',
  filters: {
    inputTypeFilter(value) {
      if (value === 1) {
        return '从列表中选取'
      } else {
        return '手工录入'
      }
    },
    selectTypeFilter(value) {
      if (value === 1) {
        return '单选'
      } else if (value === 2) {
        return '多选'
      } else {
        return '唯一'
      }
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      multipleSelection: [],
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 10
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      searchProductAttributes(this.$route.query.categoryId, this.$route.query.type, this.page.currentPage, this.page.pageSize).then(response => {
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
      this.$router.push({ path: '/goods/attributes/productAttributeAdd',
        query: { categoryId: this.$route.query.categoryId, type: this.$route.query.type }})
    },
    handleEdit(index, row) {
      this.$router.push({ path: '/goods/attributes/productAttributeEdit',
        query: { id: row.id, categoryId: this.$route.query.categoryId, type: this.$route.query.type }})
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该品牌', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeProductAttribute(row.id).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success',
            duration: 1000
          })
          this.fetchData()
        })
      })
    },
    handleManufacturerChange(index, row) {

    },
    handleShowStatusChange(index, row) {

    }
  }
}
</script>
