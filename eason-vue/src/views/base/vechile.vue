<template>
  <div class="app-container">
    <el-form :inline="true" :model="searchParams" size="medium">
      <el-form-item label="大洲">
        <el-select v-model="searchParams.continentId" placeholder="大洲" clearable @change="searchContinentChange">
          <el-option
            v-for="continent in searchFillData.continents"
            :key="continent.id"
            :value="continent.id"
            :label="continent.name"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="国家">
        <el-select v-model="searchParams.countryId" placeholder="国家" clearable filterable>
          <el-option
            v-for="country in searchFillData.countries"
            :key="country.id"
            :value="country.id"
            :label="country.name"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchData">查询</el-button>
        <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="list" element-loading-text="Loading" stripe border fit highlight-current-row size="small">
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
      <el-table-column label="车型" align="left">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="描述" align="left">
        <template slot-scope="scope">
          {{ scope.row.description }}
        </template>
      </el-table-column>
      <el-table-column label="乘座人数" align="left">
        <template slot-scope="scope">
          {{ scope.row.passengers }}
        </template>
      </el-table-column>
      <el-table-column label="大行李数" align="left">
        <template slot-scope="scope">
          {{ scope.row.bigLuggage }}
        </template>
      </el-table-column>
      <el-table-column label="小行李数" align="left">
        <template slot-scope="scope">
          {{ scope.row.smallLuggage }}
        </template>
      </el-table-column>
      <el-table-column label="国家" align="left">
        <template slot-scope="scope">
          {{ scope.row.countryName }}
        </template>
      </el-table-column>
    </el-table>
    <el-dialog :visible.sync="dialogFormVisible" :close-on-click-modal="false" title="车型编辑">
      <el-form :model="editData" label-width="120px">
        <input v-model="editData.id" type="hidden">
        <el-form-item label="编码">
          <el-col :span="12">
            <el-input v-model="editData.code" />
          </el-col>
        </el-form-item>
        <el-form-item label="车型">
          <el-col :span="12">
            <el-input v-model="editData.name" />
          </el-col>
        </el-form-item>
        <el-form-item label="乘坐人数">
          <el-col :span="12">
            <el-input v-model="editData.passengers" type="number" />
          </el-col>
        </el-form-item>
        <el-form-item label="大件行李数">
          <el-col :span="12">
            <el-input v-model="editData.bigLuggage" type="number" />
          </el-col>
        </el-form-item>
        <el-form-item label="小件行李数">
          <el-col :span="12">
            <el-input v-model="editData.smallLuggage" type="number" />
          </el-col>
        </el-form-item>
        <el-form-item label="国内同款车型">
          <el-col :span="22">
            <el-input v-model="editData.description" />
          </el-col>
        </el-form-item>
        <el-form-item label="空间描述">
          <el-col :span="22">
            <el-input v-model="editData.passengersDescription" />
          </el-col>
        </el-form-item>
        <el-form-item label="图片地址">
          <el-col :span="22">
            <el-input v-model="editData.pictureUrl" />
          </el-col>
        </el-form-item>
        <el-form-item label="国家">
          <el-select v-model="editData.continentId" placeholder="大洲" clearable @change="editContinentChange">
            <el-option
              v-for="continent in editFillData.continents"
              :key="continent.id"
              :value="continent.id"
              :label="continent.name"
            />
          </el-select>
          <el-select v-model="editData.countryId" placeholder="国家" clearable filterable>
            <el-option
              v-for="country in editFillData.countries"
              :key="country.id"
              :value="country.id"
              :label="country.name"
            />
          </el-select>
          <input v-model="editData.countryName" type="hidden">
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitVehicle">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { saveVehicle, searchVehicles } from '@/api/base/vehicle'
import { findCountries } from '@/api/base/country'
import { findContinents } from '@/api/base/continent'
export default {
  name: 'Vechile',
  data() {
    return {
      list: null,
      listLoading: true,
      dialogFormVisible: false,
      searchFillData: {
        continents: [],
        countries: []
      },
      searchParams: {
        continentId: '',
        countryId: ''
      },
      editData: {
        id: '',
        code: '',
        name: '',
        description: '',
        passengers: '',
        passengersDescription: '',
        bigLuggage: '',
        smallLuggage: '',
        pictureUrl: '',
        continentId: '',
        countryId: '',
        countryName: ''
      },
      editFillData: {
        continents: [],
        countries: []
      }
    }
  },
  created() {
    findContinents().then(response => {
      this.searchFillData.continents = response.data
      this.editFillData.continents = response.data
    })
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      searchVehicles(this.searchParams).then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    searchData() {
      this.fetchData()
    },
    searchContinentChange(continentId) {
      this.searchParams.countryId = ''
      if (!continentId) {
        this.searchFillData.countries = []
      } else {
        findCountries(continentId).then(response => {
          this.searchFillData.countries = response.data
        })
      }
    },
    editContinentChange(continentId) {
      this.editData.countryId = ''
      if (!continentId) {
        this.editFillData.countries = []
      } else {
        findCountries(continentId).then(response => {
          this.editFillData.countries = response.data
        })
      }
    },
    submitVehicle() {
      saveVehicle(this.editData).then(response => {
        this.editData = {
          id: '',
          code: '',
          name: '',
          description: '',
          passengers: '',
          passengersDescription: '',
          bigLuggage: '',
          smallLuggage: '',
          pictureUrl: '',
          continentId: '',
          countryId: '',
          countryName: ''
        }
        this.dialogFormVisible = false
        this.searchData()
      })
    }
  }
}
</script>
