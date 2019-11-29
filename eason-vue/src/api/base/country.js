import request from '@/utils/request'

export function findCountries(continentId) {
  return request({
    url: '/base/management/country',
    method: 'get',
    params: { continentId }
  })
}

export function searchCountries(params) {
  return request({
    url: '/base/management/country/search',
    method: 'get',
    params
  })
}
