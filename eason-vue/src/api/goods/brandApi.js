import request from '@/utils/request'

export function searchBrands(currentPage, pageSize, params) {
  return request({
    url: `/goods/brands/search/${currentPage}/${pageSize}`,
    method: 'get',
    params: params
  })
}

export function getAllBrands() {
  return request({
    url: '/goods/brands',
    method: 'get'
  })
}

export function getBrand(id) {
  return request({
    url: `/goods/brands/${id}`,
    method: 'get'
  })
}

export function addBrand(params) {
  return request({
    url: '/goods/brands',
    method: 'post',
    data: params
  })
}

export function editBrand(id, params) {
  return request({
    url: `/goods/brands/${id}`,
    method: 'put',
    data: params
  })
}

export function removeBrand(id) {
  return request({
    url: `/goods/brands/${id}`,
    method: 'delete'
  })
}
