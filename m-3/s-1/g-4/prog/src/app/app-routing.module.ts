import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivePostsComponent } from './active-posts/active-posts.component';
import { InactivePotsComponent } from './inactive-pots/inactive-pots.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PostDetailsComponent } from './post-details/post-details.component';

const routes: Routes = [

  {
    path:'',
    component: HomepageComponent
  },
  {
    path:'active-posts',
    component: ActivePostsComponent
  },
  {
    path:'inactive-posts',
    component: InactivePotsComponent
  },

  {
    path:'posts-details',
    component: PostDetailsComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
