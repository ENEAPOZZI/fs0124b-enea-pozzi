import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';

const routes: Route[] = [
    {
        path: '',
        component: HomeComponent,
    },
    {
        path: 'active',
        component: ActivePostsComponent,
    },
    {
        path: 'inactive',
        component: InactivePostsComponent,
    },
    {
        path: 'post/:id',
        component: PostDetailComponent,
    },
    {
        path: '**',
        redirectTo: '',
    },
];

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        NavbarComponent,
        ActivePostsComponent,
        InactivePostsComponent,
        PostDetailComponent,
    ],
    imports: [BrowserModule, RouterModule.forRoot(routes)],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
