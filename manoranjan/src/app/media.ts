import { Crew } from './crew';
import { Cast } from './cast';

export class Media {

    mediaTitle: string;
    mediaCategory: string;
    mediaSynopsis: string;
    mediaGenre: Array<string>;
    mediaLanguage: string;
    mediaReleaseDate: Date;
    mediaPosterUrl: string;
    mediaStudioName: string;
    mediaCrew: Array<Crew>;
    mediaCast: Array<Cast>;
    mediaUrl: string;
    mediaTrailerUrl: string;
    mediaType: string;

}
