<template>
    <div>
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Number
            label="AuthorId"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Number
            label="CategoryId"
            v-model="value.categoryId"
            :editMode="editMode"
        />
        <Boolean
            label="IsSubscribed"
            v-model="value.isSubscribed"
            :editMode="editMode"
        />
        <Boolean
            label="IsPublished"
            v-model="value.isPublished"
            :editMode="editMode"
        />
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <String
                label="Bestseller"
                v-model="bestsellerInput"
                :editMode="editMode"
                @keydown.enter="addBestsellerList"
            />
            <v-card v-if="value.bestseller.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    Bestseller List
                </v-card-sub-title>
                <li v-for="(name, index) in value.bestseller" :key="index">
                    {{ name }}
                </li>
            </v-card>
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addBestsellerList">
                    Bestseller 추가
                </v-btn>
            </v-row>
            
            <StringDetailGrid
                label="Bestseller"
                offline
                v-model="value.bestseller"
                :editMode="editMode"
                @change="change"
            />
        </div>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Admin',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "admins",
        bestsellerInput: null,
        value: {
            bestseller: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addBestsellerList() {
            if (this.bestsellerInput !== null && this.bestsellerInput !== '') {
                this.value.bestseller.push(this.bestsellerInput);
                this.bestsellerInput = null; // null로 초기화
            }
        },
    },
}
</script>
