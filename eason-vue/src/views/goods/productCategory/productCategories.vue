<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <el-button type="primary" @click="handleAdd()">新增</el-button>
      <el-button v-if="parentId!=0" @click="$router.back();">返回</el-button>
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
    >
      <el-table-column type="selection" align="center" />
      <el-table-column align="left" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="分类名称" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="级别" align="left">
        <template slot-scope="scope">
          {{ scope.row.level | levelFilter }}
        </template>
      </el-table-column>
      <el-table-column label="产品数量" align="left">
        <template slot-scope="scope">
          {{ scope.row.productCount }}
        </template>
      </el-table-column>
      <el-table-column label="数量单位" align="left">
        <template slot-scope="scope">
          {{ scope.row.productUnit }}
        </template>
      </el-table-column>
      <el-table-column label="导航栏" align="left">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.showNavigation"
            :active-value="true"
            :inactive-value="false"
          />
        </template>
      </el-table-column>
      <el-table-column label="是否显示" align="left">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isShow"
            :active-value="true"
            :inactive-value="false"
          />
        </template>
      </el-table-column>
      <el-table-column label="排序" align="left">
        <template slot-scope="scope">
          {{ scope.row.sort }}
        </template>
      </el-table-column>
      <el-table-column label="设置" width="200" align="center">
        <template slot-scope="scope">
          <el-button
            :disabled="scope.row.level | disableNextLevel"
            size="mini"
            @click="handleShowNextLevel(scope.$index, scope.row)"
          >查看下级
          </el-button>
          <el-button
            size="mini"
            @click="handleTransferProduct(scope.$index, scope.row)"
          >转移商品
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
  </div>
</template>

<script>
import { searchProductCategories, removeProductCategory } from '@/api/goods/productCategoryApi'

export default {
  name: 'ProductCategory',
  filters: {
    levelFilter(value) {
      if (value === 0) {
        return '一级'
      } else if (value === 1) {
        return '二级'
      }
    },
    disableNextLevel(value) {
      if (value === 0) {
        return false
      } else {
        return true
      }
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      searchParams: {
        name: ''
      },
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 10
      },
      parentId: 0
    }
  },
  created() {
    this.initParentId()
    this.fetchData()
  },
  methods: {
    initParentId() {
      if (this.$route.query.parentId != null) {
        this.parentId = this.$route.query.parentId
      } else {
        this.parentId = 0
      }
    },
    fetchData() {
      this.listLoading = true
      searchProductCategories(this.parentId, this.page.currentPage, this.page.pageSize).then(response => {
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
    handleAdd() {
      this.$router.push({ path: '/goods/productCategories/productCategoryAdd' })
    },
    handleEdit(index, row) {
      this.$router.push({ path: '/goods/productCategories/productCategoryEdit', query: { id: row.id }})
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该产品分类', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        removeProductCategory(row.id).then(response => {
          this.$message({
            message: '删除成功',
            type: 'success',
            duration: 1000
          })
          this.fetchData()
        })
      })
    },
    handleShowNextLevel(index, row) {
      this.$router.push({ path: '/goods/productCategories', query: { parentId: row.id }})
    },
    handleTransferProduct(index, row) {

    }
  }
}
</script>
