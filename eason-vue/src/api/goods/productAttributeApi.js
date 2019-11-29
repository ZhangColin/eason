import request from '@/utils/request'

export function searchProductAttributes(categoryId, type, currentPage, pageSize, params) {
  return request({
    url: `/goods/productAttributes/search/${categoryId}/${type}/${currentPage}/${pageSize}`,
    method: 'get',
    params: params
  })
}

export function getProductAttribute(id) {
  return request({
    url: `/goods/productAttributes/${id}`,
    method: 'get'
  })
}

export function addProductAttribute(params) {
  return request({
    url: '/goods/productAttributes',
    method: 'post',
    data: params
  })
}

export function editProductAttribute(id, params) {
  return request({
    url: `/goods/productAttributes/${id}`,
    method: 'put',
    data: params
  })
}

export function removeProductAttribute(id) {
  return request({
    url: `/goods/productAttributes/${id}`,
    method: 'delete'
  })
}
