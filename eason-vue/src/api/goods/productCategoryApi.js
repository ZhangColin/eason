import request from '@/utils/request'

export function searchProductCategories(parentId, currentPage, pageSize) {
  return request({
    url: `/goods/productCategories/search/${parentId}/${currentPage}/${pageSize}`,
    method: 'get'
  })
}

export function getProductCategory(id) {
  return request({
    url: `/goods/productCategories/${id}`,
    method: 'get'
  })
}

export function getProductCategoryAttributes(id) {
  return request({
    url: `/goods/productCategories/${id}/attributes`,
    method: 'get'
  })
}

export function getProductCategoriesByLevel(level) {
  return request({
    url: `/goods/productCategories`,
    method: 'get',
    params: { level }
  })
}

export function addProductCategory(params) {
  return request({
    url: '/goods/productCategories',
    method: 'post',
    data: params
  })
}

export function editProductCategory(id, params) {
  return request({
    url: `/goods/productCategories/${id}`,
    method: 'put',
    data: params
  })
}

export function removeProductCategory(id) {
  return request({
    url: `/goods/productCategories/${id}`,
    method: 'delete'
  })
}
