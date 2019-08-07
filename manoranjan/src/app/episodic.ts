import { Episode } from "./episode";
import { Crew } from './crew';
import { Cast } from './cast';

export class Episodic {
    episodicTitle: string;
    episodicCategory: string;
    episodicSynopsis: string;
    episodicLanguage: string;
    episodicPosterUrl: string;
    episodicStudioName: string;
    episodicCrew: Array<Crew>;
    episodicCast: Array<Cast>;
    episodeList: Array<Episode>;
    episodicType: string;
}
