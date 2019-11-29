<template>
  <product-attribute-form :is-edit="false" />
</template>

<script>
import productAttributeForm from './productAttributeForm'

export default {
  name: 'AddProductAttribute',
  components: { productAttributeForm }
}
</script>
