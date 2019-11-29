<template>
  <div class="app-container">
    <el-form :inline="true" :model="searchMap">
      <el-form-item label="大洲">
        <el-select v-model="searchMap.continentId" placeholder="大洲" clearable>
          <el-option v-for="continent in continents" :key="continent.id" :value="continent.id" :label="continent.name" />
        </el-select>
      </el-form-item>
      <el-form-item label="国家">
        <el-input v-model="searchMap.name" placeholder="国家" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="fetchData">查询</el-button>
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
      <el-table-column label="大洲" align="left">
        <template slot-scope="scope">
          {{ scope.row.continentName }}
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { findContinents } from '@/api/base/continent'
import { searchCountries } from '@/api/base/country'
export default {
  name: 'Country',
  data() {
    return {
      list: null,
      listLoading: true,
      searchMap: {},
      continents: []
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
      searchCountries(this.searchMap).then(response => {
        this.list = response.data
        this.listLoading = false
      })
    }
  }
}
</script>
