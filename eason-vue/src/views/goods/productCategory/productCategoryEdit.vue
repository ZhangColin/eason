<template>
  <product-category-form :is-edit="true" />
</template>

<script>
import productCategoryForm from './productCategoryForm'

export default {
  name: 'EditProductCategory',
  components: { productCategoryForm }
}
</script>
