<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Authordm' }" />
        <VerticalNavLink
            :item="{
                title: 'Author',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 도서 목록',
                to: '/authorBookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Aiservice' }" />
        <VerticalNavLink
            :item="{
                title: 'Publishing',
                to: '/publishings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'pointdm' }" />
        <VerticalNavLink
            :item="{
                title: 'Point',
                to: '/points',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 구독 도서 목록',
                to: '/userSubscribedBookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'userdm' }" />
        <VerticalNavLink
            :item="{
                title: 'User',
                to: '/users',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 관심 도서 목록',
                to: '/userWishlists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 도서 리뷰 목록',
                to: '/userReviews',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'admindm' }" />
        <VerticalNavLink
            :item="{
                title: 'Admin',
                to: '/admins',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 출간 도서 리스트',
                to: '/authorPublishBooklists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 구독 도서 목록',
                to: '/userSubscribedBookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'authordm' }" />
        <VerticalNavLink
            :item="{
                title: 'author',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '원고 목록 ',
                to: '/manuscriptLists',
            }"
        />
    </ul>
</template>
