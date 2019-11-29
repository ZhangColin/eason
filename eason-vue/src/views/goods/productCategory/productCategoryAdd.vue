<template>
  <product-category-form :is-edit="false" />
</template>

<script>
import productCategoryForm from './productCategoryForm'

export default {
  name: 'AddProductCategory',
  components: { productCategoryForm }
}
</script>
