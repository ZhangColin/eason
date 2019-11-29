<template>
  <product-attribute-form :is-edit="true" />
</template>

<script>
import productAttributeForm from './productAttributeForm'

export default {
  name: 'EditProductAttribute',
  components: { productAttributeForm }
}
</script>
