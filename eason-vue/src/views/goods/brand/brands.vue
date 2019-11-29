<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <el-form :inline="true" :model="searchParams" size="small">
        <el-form-item>
          <el-input v-model="searchParams.name" placeholder="品牌名称/关键字" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleSearch">查询</el-button>
          <el-button type="primary" @click="handleAdd()">新增</el-button>
        </el-form-item>
      </el-form>
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
      <el-table-column label="品牌名称" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="品牌首字母" align="left">
        <template slot-scope="scope">
          {{ scope.row.firstLetter }}
        </template>
      </el-table-column>
      <el-table-column label="品牌制造商" align="left">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isManufacturer"
            :active-value="true"
            :inactive-value="false"
            @change="handleManufacturerChange(scope.$index, scope.row)"
          />
        </template>
      </el-table-column>
      <el-table-column label="是否显示" align="left">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isShow"
            :active-value="true"
            :inactive-value="false"
            @change="handleShowStatusChange(scope.$index, scope.row)"
          />
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
import { searchBrands, removeBrand } from '@/api/goods/brandApi'

export default {
  name: 'Brand',
  data() {
    return {
      list: null,
      listLoading: true,
      multipleSelection: [],
      searchParams: {
        name: ''
      },
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
      searchBrands(this.page.currentPage, this.page.pageSize, this.searchParams).then(response => {
        this.list = response.data.rows
        this.page.total = response.data.total
        this.listLoading = false
      })
    },
    handleSearch() {
      this.page.currentPage = 1
      this.fetchData()
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
      this.$router.push({ path: '/goods/brands/brandAdd' })
    },
    handleEdit(index, row) {
      this.$router.push({ path: '/goods/brands/brandEdit', query: { id: row.id }})
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该品牌', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeBrand(row.id).then(response => {
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
