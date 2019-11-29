import request from '@/utils/request'

export function getAllProductAttributeCategories() {
  return request({
    url: '/goods/productAttributeCategories',
    method: 'get'
  })
}

export function findAllParams() {
  return request({
    url: '/goods/productAttributeCategories/params',
    method: 'get'
  })
}

export function searchProductAttributeCategories(currentPage, pageSize) {
  return request({
    url: `/goods/productAttributeCategories/search/${currentPage}/${pageSize}`,
    method: 'get'
  })
}

export function getProductAttributeCategory(id) {
  return request({
    url: `/goods/productAttributeCategories/${id}`,
    method: 'get'
  })
}

export function addProductAttributeCategory(name) {
  return request({
    url: '/goods/productAttributeCategories',
    method: 'post',
    params: { name }
  })
}

export function editProductAttributeCategory(id, name) {
  return request({
    url: `/goods/productAttributeCategories/${id}`,
    method: 'put',
    params: { name }
  })
}

export function removeProductAttributeCategory(id) {
  return request({
    url: `/goods/productAttributeCategories/${id}`,
    method: 'delete'
  })
}
