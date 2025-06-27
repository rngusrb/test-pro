<template>
    <div>
        <String
            label="Userid"
            v-model="value.userid"
            :editMode="editMode"
        />
        <String
            label="UserType"
            v-model="value.userType"
            :editMode="editMode"
        />
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <String
                label="Wishlist"
                v-model="wishlistInput"
                :editMode="editMode"
                @keydown.enter="addWishlistList"
            />
            <v-card v-if="value.wishlist.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    Wishlist List
                </v-card-sub-title>
                <li v-for="(name, index) in value.wishlist" :key="index">
                    {{ name }}
                </li>
            </v-card>
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addWishlistList">
                    Wishlist 추가
                </v-btn>
            </v-row>
            
            <StringDetailGrid
                label="Wishlist"
                offline
                v-model="value.wishlist"
                :editMode="editMode"
                @change="change"
            />
        </div>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <Reviews v-model="reviewsInput"
                offline
                label="Reviews"
                :editMode="editMode"
                @change="change"
            />
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addReviewsList">Reviews Add</v-btn>
            </v-row>
            <v-card v-if="value.reviews.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    Reviews List
                </v-card-sub-title>
                <li v-for="(id, index) in value.reviews" :key="index">
                    {{ id && id. ? id. : '' }}
                </li>
            </v-card>
        </div>
        <String
            label="SubscriptionStatus"
            v-model="value.subscriptionStatus"
            :editMode="editMode"
        />
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
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users",
        wishlistInput: null,
        reviewsInput: null,
        value: {
            wishlist: [],
            reviews: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addWishlistList() {
            if (this.wishlistInput !== null && this.wishlistInput !== '') {
                this.value.wishlist.push(this.wishlistInput);
                this.wishlistInput = null; // null로 초기화
            }
        },
        addReviewsList() {
            if (this.reviewsInput !== null && this.reviewsInput !== '') {
                this.value.reviews.push(this.reviewsInput);
                this.reviewsInput = null; // null로 초기화
            }
        },
    },
}
</script>
