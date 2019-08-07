import { Genre } from './genre';
import { Language } from './language';

export class Recommendation {

    mediaTitle: string;
    mediaCategory: string; 
    mediaGenre: Array<string>; 
    mediaLanguage: string;
    episodeTitle: string;
    episodeCategory: string;  
    episodeLanguage: string;  
    genre: Array<Genre>;
    language: Array<Language>;
    name: string;
    emailId: string;  
    interest: Array<string>;

}
