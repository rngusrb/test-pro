import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/authorBookLists',
      component: () => import('../components/AuthorBookListView.vue'),
    },
    {
      path: '/publishings',
      component: () => import('../components/ui/PublishingGrid.vue'),
    },
    {
      path: '/points',
      component: () => import('../components/ui/PointGrid.vue'),
    },
    {
      path: '/userSubscribedBookLists',
      component: () => import('../components/UserSubscribedBookListView.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/userWishlists',
      component: () => import('../components/UserWishlistView.vue'),
    },
    {
      path: '/userReviews',
      component: () => import('../components/UserReviewView.vue'),
    },
    {
      path: '/플랫폼관리',
      component: () => import('../components/ui/플랫폼관리Grid.vue'),
    },
    {
      path: '/authorPublishBooklists',
      component: () => import('../components/AuthorPublishBooklistView.vue'),
    },
    {
      path: '/userSubscribedBookLists',
      component: () => import('../components/UserSubscribedBookListView.vue'),
    },
    {
      path: '/원고',
      component: () => import('../components/ui/원고Grid.vue'),
    },
    {
      path: '/manuscriptLists',
      component: () => import('../components/ManuscriptListView.vue'),
    },
  ],
})

export default router;
