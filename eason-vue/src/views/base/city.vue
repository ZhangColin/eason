<template>
  <div class="app-container">
    <el-form :inline="true" :model="searchParams">
      <el-form-item label="大洲">
        <el-select v-model="searchParams.continentId" placeholder="大洲" clearable @change="continentSelectChange">
          <el-option
            v-for="continent in continents"
            :key="continent.id"
            :value="continent.id"
            :label="continent.name"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="国家">
        <el-select v-model="searchParams.countryId" placeholder="国家" clearable filterable>
          <el-option
            v-for="country in countries"
            :key="country.id"
            :value="country.id"
            :label="country.name"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="城市">
        <el-input v-model="searchParams.name" placeholder="城市" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchData">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="list" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="left" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="编码" align="left">
        <template slot-scope="scope">
          {{ scope.row.code }}
        </template>
      </el-table-column>
      <el-table-column label="名称" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="英文名" align="left">
        <template slot-scope="scope">
          {{ scope.row.englishName }}
        </template>
      </el-table-column>
      <el-table-column label="全拼" align="left">
        <template slot-scope="scope">
          {{ scope.row.fullPinYin }}
        </template>
      </el-table-column>
      <el-table-column label="简拼" align="left">
        <template slot-scope="scope">
          {{ scope.row.simplePinYin }}
        </template>
      </el-table-column>
      <el-table-column label="经纬度" align="left">
        <template slot-scope="scope">
          {{ scope.row.latitude }},{{ scope.row.longitude }}
        </template>
      </el-table-column>
      <el-table-column label="国家" align="left">
        <template slot-scope="scope">
          {{ scope.row.countryName }}
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :current-page="page.currentPage"
      :page-sizes="[5, 10, 20]"
      :page-size="page.pageSize"
      :total="page.total"
      align="right"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="sizeChange"
      @current-change="currentChange"
    />
  </div>
</template>

<script>
import { searchCities } from '@/api/base/city'
import { findCountries } from '@/api/base/country'
import { findContinents } from '@/api/base/continent'
export default {
  name: 'City',
  data() {
    return {
      list: null,
      listLoading: false,
      continents: [],
      countries: [],
      searchParams: {
        continentId: '',
        countryId: '',
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
    findContinents().then(response => {
      this.continents = response.data
    })
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      searchCities(this.page.currentPage, this.page.pageSize, this.searchParams).then(response => {
        this.list = response.data.rows
        this.page.total = response.data.total
        this.listLoading = false
      })
    },
    searchData() {
      this.page.currentPage = 1
      this.fetchData()
    },
    sizeChange(pageSize) {
      this.page.currentPage = 1
      this.page.pageSize = pageSize
      this.fetchData()
    },
    currentChange(currentPage) {
      this.page.currentPage = currentPage
      this.fetchData()
    },
    continentSelectChange(continentId) {
      this.searchParams.countryId = ''
      if (!continentId) {
        this.countries = []
      } else {
        findCountries(continentId).then(response => {
          this.countries = response.data
        })
      }
    }
  }
}
</script>
