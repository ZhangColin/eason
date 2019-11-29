import request from '@/utils/request'

export function findCities(countryId) {
  return request({
    url: '/base/city',
    method: 'get',
    params: { countryId }
  })
}

export function searchCities(currentPage, pageSize, params) {
  return request({
    url: `/base/city/search/${currentPage}/${pageSize}`,
    method: 'get',
    params
  })
}
