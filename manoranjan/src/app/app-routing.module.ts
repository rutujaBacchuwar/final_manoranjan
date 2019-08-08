import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FaqComponent } from './faq/faq.component';
import { DocumentaryComponent } from './documentary/documentary.component';
import { LandingComponent } from './landing/landing.component';
import { NavLandComponent } from './nav-land/nav-land.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavNormComponent } from './nav-norm/nav-norm.component';
import { MoviesComponent } from './movies/movies.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { ImageComponent } from './image/image.component';
import { LinknormviewComponent } from './linknormview/linknormview.component';
import { LinkpriviewComponent } from './linkpriview/linkpriview.component';
import { LinkpriviewloginComponent } from './linkpriviewlogin/linkpriviewlogin.component';
import { LinkDocNorComponent } from './link-doc-nor/link-doc-nor.component';
import { LinkDocPriComponent } from './link-doc-pri/link-doc-pri.component';
import { LinkTvNorComponent } from './link-tv-nor/link-tv-nor.component';
import { LinkTvPriComponent } from './link-tv-pri/link-tv-pri.component';
import { LinkMovieNorComponent } from './link-movie-nor/link-movie-nor.component';
import { LinkMoviePriComponent } from './link-movie-pri/link-movie-pri.component';
import { LinkWebNorComponent } from './link-web-nor/link-web-nor.component';
import { LinkWebPriComponent } from './link-web-pri/link-web-pri.component';
import { PackageComponent } from './package/package.component';
import { PaymentComponent } from './payment/payment.component';
import { ActionmovienormComponent } from './actionmovienorm/actionmovienorm.component';
import { HorrormovienormComponent } from './horrormovienorm/horrormovienorm.component';
import { RomanticmovienormComponent } from './romanticmovienorm/romanticmovienorm.component';
import { ThrillermovienormComponent } from './thrillermovienorm/thrillermovienorm.component';
import { ComedymovienormComponent } from './comedymovienorm/comedymovienorm.component';
import { MysterymovienormComponent } from './mysterymovienorm/mysterymovienorm.component';
import { HindiserialnormComponent } from './hindiserialnorm/hindiserialnorm.component';
import { EnglishserialnormComponent } from './englishserialnorm/englishserialnorm.component';
import { MarathiserialnormComponent } from './marathiserialnorm/marathiserialnorm.component';
import { TamilserialnormComponent } from './tamilserialnorm/tamilserialnorm.component';
import { TeluguserialnormComponent } from './teluguserialnorm/teluguserialnorm.component';
import { GujarathiserialnormComponent } from './gujarathiserialnorm/gujarathiserialnorm.component';
import { BengaliserialnormComponent } from './bengaliserialnorm/bengaliserialnorm.component';
import { ActionmoviepriComponent } from './actionmoviepri/actionmoviepri.component';
import { HorrormoviepriComponent } from './horrormoviepri/horrormoviepri.component';
import { ComedymoviepriComponent } from './comedymoviepri/comedymoviepri.component';
import { ThrillermoviepriComponent } from './thrillermoviepri/thrillermoviepri.component';
import { RomanticmoviepriComponent } from './romanticmoviepri/romanticmoviepri.component';
import { MysterymoviepriComponent } from './mysterymoviepri/mysterymoviepri.component';
import { HindiserialpriComponent } from './hindiserialpri/hindiserialpri.component';
import { EnglishserialpriComponent } from './englishserialpri/englishserialpri.component';
import { MarathiserialpriComponent } from './marathiserialpri/marathiserialpri.component';
import { TamilserialpriComponent } from './tamilserialpri/tamilserialpri.component';
import { TeluguserialpriComponent } from './teluguserialpri/teluguserialpri.component';
import { GujarathiserialpriComponent } from './gujarathiserialpri/gujarathiserialpri.component';
import { BengaliserialpriComponent } from './bengaliserialpri/bengaliserialpri.component';
import { HistoryComponent } from './history/history.component';
import { MythologymovienormComponent } from './mythologymovienorm/mythologymovienorm.component';
import { BiopicmovienormComponent } from './biopicmovienorm/biopicmovienorm.component';
import { SciencefictionmovienormComponent } from './sciencefictionmovienorm/sciencefictionmovienorm.component';
import { BiopicmoviepriComponent } from './biopicmoviepri/biopicmoviepri.component';
import { SciencefictionmoviepriComponent } from './sciencefictionmoviepri/sciencefictionmoviepri.component';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { EditComponent } from './edit/edit.component';
import { StandaloneStepperComponent } from './standalone-stepper/standalone-stepper.component';
import { StandaloneEpisodicComponent } from './standalone-episodic/standalone-episodic.component';
import { ProducernavComponent } from './producernav/producernav.component';
import { ProducerprofileComponent } from './producerprofile/producerprofile.component';
import { EditproducerprofileComponent } from './editproducerprofile/editproducerprofile.component';
import { EpisodicComponent } from './episodic/episodic.component';
import { PlayComponent } from './play/play.component';
import { DatePipe } from '@angular/common';
import { PaymentdialogComponent } from './paymentdialog/paymentdialog.component';
import { ProducerdialogComponent} from './producerdialog/producerdialog.component';
import { UserdialogComponent } from './userdialog/userdialog.component';

const routes: Routes = [
  { path: 'feedback', component: FeedbackComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'document', component: LinkDocNorComponent },
  { path: 'land', component: LandingComponent },
  { path: 'navland', component: NavLandComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'navnorm', component: NavNormComponent },
  {path: 'movie/:title',component:MoviesComponent},
  {path: 'wish',component:WishlistComponent},
  {path: 'movie',component:LinkMovieNorComponent},
  {path: 'tv',component:LinkTvNorComponent},
  {path: 'web',component:LinkWebNorComponent},
  {path: 'image',component:ImageComponent},
  {path: 'linknorm',component:LinknormviewComponent},
  {path: 'linkpri',component:LinkpriviewComponent},
  {path: 'linkprilog',component:LinkpriviewloginComponent},
  {path: 'linkdocpri',component:LinkDocPriComponent},
  {path: 'linktvpri',component:LinkTvPriComponent},
  {path: 'linkmoviepri',component:LinkMoviePriComponent},
  {path: 'linkwebpri',component:LinkWebPriComponent},
  {path: 'actionmovie',component:ActionmovienormComponent},
  {path: 'horrormovie',component:HorrormovienormComponent},
  {path: 'comedymovie',component:ComedymovienormComponent},
  {path: 'thrillermovie',component:ThrillermovienormComponent},
  {path: 'romanticmovie',component:RomanticmovienormComponent},
  {path: 'mysterymovie',component:MysterymovienormComponent},
  {path: 'mythologymovie',component:MythologymovienormComponent},
  {path: 'biopicmovie',component:BiopicmovienormComponent},
  {path: 'sciencefictionmovie',component:SciencefictionmovienormComponent},
  {path: 'hindiserial',component:HindiserialnormComponent},
  {path: 'englishserial',component:EnglishserialnormComponent},
  {path: 'marathiserial',component:MarathiserialnormComponent},
  {path: 'tamilserial',component:TamilserialnormComponent},
  {path: 'taluguserial',component:TeluguserialnormComponent},
  {path: 'gujarathiserial',component:GujarathiserialnormComponent},
  {path: 'bengaliserial',component:BengaliserialnormComponent},
  {path: 'actionmoviepri',component:ActionmoviepriComponent},
  {path: 'horrormoviepri',component:HorrormoviepriComponent},
  {path: 'comedymoviepri',component:ComedymoviepriComponent},
  {path: 'kidsmoviepri',component:ThrillermoviepriComponent},
  {path: 'romanticmoviepri',component:RomanticmoviepriComponent},
  {path: 'mysterymoviepri',component:MysterymoviepriComponent},
  {path: 'mythologymoviepri',component:MysterymoviepriComponent},
  {path: 'biopicmoviepri',component:BiopicmoviepriComponent},
  {path: 'sciencefictionmoviepri',component:SciencefictionmoviepriComponent},
  {path: 'hindiserialpri',component:HindiserialpriComponent},
  {path: 'englishserialpri',component:EnglishserialpriComponent},
  {path: 'marathiserialpri',component:MarathiserialpriComponent},
  {path: 'tamilserialpri',component:TamilserialpriComponent},
  {path: 'taluguserialpri',component:TeluguserialpriComponent},
  {path: 'gujarathiserialpri',component:GujarathiserialpriComponent},
  {path: 'bengaliserialpri',component:BengaliserialpriComponent},
  {path: 'history',component:HistoryComponent},
  {path: 'nav',component:MainNavComponent},
  {path :'about1',component:AboutComponent},
  {path :'package',component:PackageComponent},
  {path :'package/:email',component:PackageComponent},
  {path :'payment/:time/:amount',component:PaymentComponent},
  {path :'paymentdialog/:time/:amount',component:PaymentdialogComponent},
  {path :'producerdialog',component:ProducerdialogComponent},
  {path :'userdialog',component:UserdialogComponent},
  {path:'myaccount',component:MyaccountComponent},
  {path:'edit/:email',component:EditComponent},
  {path:'editpro/:email',component:EditproducerprofileComponent},
  {path :'payment',component:PaymentComponent},
  {path :'producerpro',component:ProducerprofileComponent},
  {path :'producer',component:ProducernavComponent},
  {path:'standaloneepisodic',component:StandaloneEpisodicComponent},
  {path:'episodic/:title/:category/:synopsis',component:EpisodicComponent},
  {path:'standalonestepper/:title/:category/:synopsis',component:StandaloneStepperComponent},
  {path:'play/:title/:url',component:PlayComponent},
  {path: '**', redirectTo: '/navland'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  providers: [DatePipe],
  exports: [RouterModule]
})
export class AppRoutingModule { }
