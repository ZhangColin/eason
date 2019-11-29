<template>
  <brand-form :is-edit="false" />
</template>

<script>
import brandForm from './brandForm'

export default {
  name: 'AddBrand',
  components: { brandForm }
}
</script>
