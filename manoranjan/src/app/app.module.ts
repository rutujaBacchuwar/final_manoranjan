import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatRadioModule } from '@angular/material/radio';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatToolbarModule, MatListModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { CarousalComponent } from './carousal/carousal.component';
import { FirstcardComponent } from './firstcard/firstcard.component';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { SecondcardComponent } from './secondcard/secondcard.component';
import { ThirdcardComponent } from './thirdcard/thirdcard.component';
import { FooterComponent } from './footer/footer.component';
import { AboutComponent } from './about/about.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FaqComponent } from './faq/faq.component';
import { DocumentaryComponent } from './documentary/documentary.component';
import { LandingComponent } from './landing/landing.component';
import { NavLandComponent } from './nav-land/nav-land.component';
import { PopularclipsComponent } from './popularclips/popularclips.component';
import { InformationComponent } from './information/information.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavNormComponent } from './nav-norm/nav-norm.component';
import { NormcarousalComponent } from './normcarousal/normcarousal.component';
import { MoviesComponent } from './movies/movies.component';
import { MoviedescriptionComponent } from './moviedescription/moviedescription.component';
import { TvComponent } from './tv/tv.component';
import { WebComponent } from './web/web.component';
import { ImageComponent } from './image/image.component';
import { LikeCardComponent } from './like-card/like-card.component';
import { EpisoderecommendationComponent } from './episoderecommendation/episoderecommendation.component';
import { MatStepperModule } from '@angular/material/stepper';
import { HindiserialsComponent } from './hindiserials/hindiserials.component';
import { MarathiserialsComponent } from './marathiserials/marathiserials.component';
import { TeluguserialsComponent } from './teluguserials/teluguserials.component';
import { TamilserialsComponent } from './tamilserials/tamilserials.component';
import { BengaliserialsComponent } from './bengaliserials/bengaliserials.component';
import { EnglishserialsComponent } from './englishserials/englishserials.component';
import { GujarathiserialsComponent } from './gujarathiserials/gujarathiserials.component';
import { ActionmoviesComponent } from './actionmovies/actionmovies.component';
import { HorrormoviesComponent } from './horrormovies/horrormovies.component';
import { RomanticmoviesComponent } from './romanticmovies/romanticmovies.component';
import { ThrillermoviesComponent } from './thrillermovies/thrillermovies.component';
import { ComedymoviesComponent } from './comedymovies/comedymovies.component';
import { MysterymoviesComponent } from './mysterymovies/mysterymovies.component';
import { LinknormviewComponent } from './linknormview/linknormview.component';
import { LinkpriviewComponent } from './linkpriview/linkpriview.component';
import { LinkpriviewloginComponent } from './linkpriviewlogin/linkpriviewlogin.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { LinkDocNorComponent } from './link-doc-nor/link-doc-nor.component';
import { LinkDocPriComponent } from './link-doc-pri/link-doc-pri.component';
import { LinkTvNorComponent } from './link-tv-nor/link-tv-nor.component';
import { LinkTvPriComponent } from './link-tv-pri/link-tv-pri.component';
import { LinkMovieNorComponent } from './link-movie-nor/link-movie-nor.component';
import { LinkMoviePriComponent } from './link-movie-pri/link-movie-pri.component';
import { LinkWebNorComponent } from './link-web-nor/link-web-nor.component';
import { LinkWebPriComponent } from './link-web-pri/link-web-pri.component';
import { PaymentComponent } from './payment/payment.component';
import { PackageComponent } from './package/package.component';
import { ActionmovienormComponent } from './actionmovienorm/actionmovienorm.component';
import { HorrormovienormComponent } from './horrormovienorm/horrormovienorm.component';
import { RomanticmovienormComponent } from './romanticmovienorm/romanticmovienorm.component';
import { ThrillermovienormComponent } from './thrillermovienorm/thrillermovienorm.component';
import { ComedymovienormComponent } from './comedymovienorm/comedymovienorm.component';
import { MysterymovienormComponent } from './mysterymovienorm/mysterymovienorm.component';
import { ActionmoviepriComponent } from './actionmoviepri/actionmoviepri.component';
import { HorrormoviepriComponent } from './horrormoviepri/horrormoviepri.component';
import { RomanticmoviepriComponent } from './romanticmoviepri/romanticmoviepri.component';
import { ThrillermoviepriComponent } from './thrillermoviepri/thrillermoviepri.component';
import { ComedymoviepriComponent } from './comedymoviepri/comedymoviepri.component';
import { MysterymoviepriComponent } from './mysterymoviepri/mysterymoviepri.component';
import { HindiserialnormComponent } from './hindiserialnorm/hindiserialnorm.component';
import { EnglishserialnormComponent } from './englishserialnorm/englishserialnorm.component';
import { MarathiserialnormComponent } from './marathiserialnorm/marathiserialnorm.component';
import { TamilserialnormComponent } from './tamilserialnorm/tamilserialnorm.component';
import { TeluguserialnormComponent } from './teluguserialnorm/teluguserialnorm.component';
import { GujarathiserialnormComponent } from './gujarathiserialnorm/gujarathiserialnorm.component';
import { BengaliserialnormComponent } from './bengaliserialnorm/bengaliserialnorm.component';
import { BengaliserialpriComponent } from './bengaliserialpri/bengaliserialpri.component';
import { GujarathiserialpriComponent } from './gujarathiserialpri/gujarathiserialpri.component';
import { TeluguserialpriComponent } from './teluguserialpri/teluguserialpri.component';
import { TamilserialpriComponent } from './tamilserialpri/tamilserialpri.component';
import { MarathiserialpriComponent } from './marathiserialpri/marathiserialpri.component';
import { EnglishserialpriComponent } from './englishserialpri/englishserialpri.component';
import { HindiserialpriComponent } from './hindiserialpri/hindiserialpri.component';
import { MythologymoviepriComponent } from './mythologymoviepri/mythologymoviepri.component';
import { MythologymovienormComponent } from './mythologymovienorm/mythologymovienorm.component';
import { BiopicmoviepriComponent } from './biopicmoviepri/biopicmoviepri.component';
import { BiopicmovienormComponent } from './biopicmovienorm/biopicmovienorm.component';
import { SciencefictionmoviepriComponent } from './sciencefictionmoviepri/sciencefictionmoviepri.component';
import { SciencefictionmovienormComponent } from './sciencefictionmovienorm/sciencefictionmovienorm.component';
import { MythologymoviesComponent } from './mythologymovies/mythologymovies.component';
import { BiopicmoviesComponent } from './biopicmovies/biopicmovies.component';
import { SciencefictionmoviesComponent } from './sciencefictionmovies/sciencefictionmovies.component';
import { HistoryComponent } from './history/history.component';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { EditComponent } from './edit/edit.component';
import { ProducerprofileComponent } from './producerprofile/producerprofile.component';
import { EditproducerprofileComponent } from './editproducerprofile/editproducerprofile.component';
import { UploadedvideosComponent } from './uploadedvideos/uploadedvideos.component';
import { StandaloneStepperComponent } from './standalone-stepper/standalone-stepper.component';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { StandaloneEpisodicComponent } from './standalone-episodic/standalone-episodic.component';
import { EpisodicComponent } from './episodic/episodic.component';
import { PlayComponent } from './play/play.component';
import { ProducernavComponent } from './producernav/producernav.component';
import { DatacardComponent } from './datacard/datacard.component';
import { DatacardepisodicComponent } from './datacardepisodic/datacardepisodic.component';
import { NavComponent } from './nav/nav.component';
import { PaymentdialogComponent } from './paymentdialog/paymentdialog.component';
import { ProducerdialogComponent } from './producerdialog/producerdialog.component';
import { UserdialogComponent } from './userdialog/userdialog.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { UploadedComponent } from './uploaded/uploaded.component';


@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    CarousalComponent,
    FirstcardComponent,
    SecondcardComponent,
    ThirdcardComponent,
    FooterComponent,
    AboutComponent,
    FeedbackComponent,
    FaqComponent,
    DocumentaryComponent,
    LandingComponent,
    NavLandComponent,
    PopularclipsComponent,
    InformationComponent,
    LoginComponent,
    RegistrationComponent,
    NavNormComponent,
    NormcarousalComponent,
    MoviesComponent,
    MoviedescriptionComponent,
    TvComponent,
    WebComponent,
    ImageComponent,
    EpisoderecommendationComponent,
    LikeCardComponent,
    HindiserialsComponent,
    MarathiserialsComponent,
    TeluguserialsComponent,
    TamilserialsComponent,
    BengaliserialsComponent,
    EnglishserialsComponent,
    GujarathiserialsComponent,
    ActionmoviesComponent,
    HorrormoviesComponent,
    RomanticmoviesComponent,
    ThrillermoviesComponent,
    ComedymoviesComponent,
    MysterymoviesComponent,
    LinknormviewComponent,
    LinkpriviewComponent,
    LinkpriviewloginComponent,
    WishlistComponent,
    LinkDocNorComponent,
    LinkDocPriComponent,
    LinkTvNorComponent,
    LinkTvPriComponent,
    LinkMovieNorComponent,
    LinkMoviePriComponent,
    LinkWebNorComponent,
    LinkWebPriComponent,
    PaymentComponent,
    PackageComponent,
    ActionmovienormComponent,
    HorrormovienormComponent,
    RomanticmovienormComponent,
    ThrillermovienormComponent,
    ComedymovienormComponent,
    MysterymovienormComponent,
    ActionmoviepriComponent,
    HorrormoviepriComponent,
    RomanticmoviepriComponent,
    ThrillermoviepriComponent,
    ComedymoviepriComponent,
    MysterymoviepriComponent,
    HindiserialnormComponent,
    EnglishserialnormComponent,
    MarathiserialnormComponent,
    TamilserialnormComponent,
    TeluguserialnormComponent,
    GujarathiserialnormComponent,
    BengaliserialnormComponent,
    BengaliserialpriComponent,
    GujarathiserialpriComponent,
    TeluguserialpriComponent,
    TamilserialpriComponent,
    MarathiserialpriComponent,
    EnglishserialpriComponent,
    HindiserialpriComponent,
    HistoryComponent,
    MythologymoviepriComponent,
    MythologymovienormComponent,
    BiopicmoviepriComponent,
    BiopicmovienormComponent,
    SciencefictionmoviepriComponent,
    SciencefictionmovienormComponent,
    MythologymoviesComponent,
    BiopicmoviesComponent,
    SciencefictionmoviesComponent,
    MyaccountComponent,
    EditComponent,
    ProducerprofileComponent,
    EditproducerprofileComponent,
    UploadedvideosComponent,
    StandaloneStepperComponent,
    StandaloneEpisodicComponent,
    EpisodicComponent,
    PlayComponent,
    ProducernavComponent,
    DatacardComponent,
    DatacardepisodicComponent,
    ProducernavComponent,
    NavComponent,
    PaymentdialogComponent,
    ProducerdialogComponent,
    UserdialogComponent,
    UploadedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatMenuModule,
    MatSidenavModule,
    LayoutModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    Ng2CarouselamosModule,
    MatStepperModule,
    MatCardModule,
    MatGridListModule,
    MatRadioModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonToggleModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [MatButtonModule, MatCheckboxModule],
})
export class AppModule { }
