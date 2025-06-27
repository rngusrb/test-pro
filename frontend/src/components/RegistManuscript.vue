<template>

    <v-card outlined>
        <v-card-title>
            RegistManuscript
        </v-card-title>

        <v-card-text>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="AuthorName" v-model="value.authorName" :editMode="editMode"/>
            <Date label="Date" v-model="value.date" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <String label="Type" v-model="value.type" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="registManuscript"
            >
                RegistManuscript
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
    name: 'RegistManuscriptCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.title = '';
        this.value.authorName = '';
        this.value.date = '2025-06-27';
        this.value.content = '';
        this.value.type = '';
    },
    watch: {
    },
    methods: {
        registManuscript() {
            this.$emit('registManuscript', this.value);
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

