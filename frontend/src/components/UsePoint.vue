<template>

    <v-card outlined>
        <v-card-title>
            UsePoint
        </v-card-title>

        <v-card-text>
            <Number label="Point" v-model="value.point" :editMode="editMode"/>
            <String label="UserType" v-model="value.userType" :editMode="editMode"/>
            <SubscriptionType offline label="SubscriptionType" v-model="value.subscriptionType" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="usePoint"
            >
                UsePoint
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'UsePointCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.point = 0;
        this.value.userType = '';
        this.value.subscriptionType = {};
    },
    watch: {
    },
    methods: {
        usePoint() {
            this.$emit('usePoint', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

