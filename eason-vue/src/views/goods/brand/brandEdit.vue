<template>
  <brand-form :is-edit="true" />
</template>

<script>
import brandForm from './brandForm'

export default {
  name: 'EditBrand',
  components: { brandForm }
}
</script>
