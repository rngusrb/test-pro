<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 도서 목록',
                to: '/authorBookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'AiService' }" />
        <VerticalNavLink
            :item="{
                title: '출간 준비',
                to: '/publishings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '포인트관리' }" />
        <VerticalNavLink
            :item="{
                title: '포인트',
                to: '/points',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '사용자 구독 도서 목록',
                to: '/userSubscribedBookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독자 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독자',
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
        <VerticalNavSectionTitle :item="{ heading: '서재플랫폼' }" />
        <VerticalNavLink
            :item="{
                title: '플랫폼관리',
                to: '/플랫폼관리',
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
        <VerticalNavSectionTitle :item="{ heading: '집필관리' }" />
        <VerticalNavLink
            :item="{
                title: '원고',
                to: '/원고',
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
