<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작가",
          link: "/authors",
      },
      {
          text: "작가 도서 목록",
          link: "/authorBookLists",
      },
      {
          text: "출간 준비",
          link: "/publishings",
      },
      {
          text: "포인트",
          link: "/points",
      },
      {
          text: "사용자 구독 도서 목록",
          link: "/userSubscribedBookLists",
      },
      {
          text: "구독자",
          link: "/users",
      },
      {
          text: "사용자 관심 도서 목록",
          link: "/userWishlists",
      },
      {
          text: "사용자 도서 리뷰 목록",
          link: "/userReviews",
      },
      {
          text: "플랫폼관리",
          link: "/플랫폼관리",
      },
      {
          text: "작가 출간 도서 리스트",
          link: "/authorPublishBooklists",
      },
      {
          text: "사용자 구독 도서 목록",
          link: "/userSubscribedBookLists",
      },
      {
          text: "원고",
          link: "/원고",
      },
      {
          text: "원고 목록 ",
          link: "/manuscriptLists",
      },
    ],
  }),
};
</script>
