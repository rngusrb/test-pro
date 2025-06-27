<template>

    <v-card outlined>
        <v-card-title>
            SaveManuscript
        </v-card-title>

        <v-card-text>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <Number label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="saveManuscript"
            >
                SaveManuscript
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
    name: 'SaveManuscriptCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.content = '';
        this.value.manuscriptId = 0;
    },
    watch: {
    },
    methods: {
        saveManuscript() {
            this.$emit('saveManuscript', this.value);
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

