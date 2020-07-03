package com.fghilmany.themoviedbwithjetpack.utils

import com.fghilmany.themoviedbwithjetpack.data.MovieEntity

object DataDummy {

    fun getDummyMovie(): List<MovieEntity>{

        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
                "m01",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m02",
                "Avengers: Endgame",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m03",
                "The Avengers",
                "When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/RYMX2wcKCBAr24UyPD7xwmjaTn.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m04",
                "Snowden",
                "CIA employee Edward Snowden leaks thousands of classified documents to the press.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4aUJAkEiuGqtbkpRJ4uZwdAmEa9.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m05",
                "Catch Me If You Can",
                "A true story about Frank Abagnale Jr. who, before his 19th birthday, successfully conned millions of dollars worth of checks as a Pan Am pilot, doctor, and legal prosecutor. An FBI agent makes it his mission to put him behind bars. But Frank not only eludes capture, he revels in the pursuit.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vG3YcgXuZABv7C8nd5bEyuMfyTQ.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m06",
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qa6HCwP4Z15l3hpsASz3auugEW6.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m07",
                "Cars 2",
                "Star race car Lightning McQueen and his pal Mater head overseas to compete in the World Grand Prix race. But the road to the championship becomes rocky as Mater gets caught up in an intriguing adventure of his own: international espionage.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/okIz1HyxeVOMzYwwHUjH2pHi74I.jpg"
            )
        )


        movie.add(
            MovieEntity(
                "m08",
                "Cars 3",
                "Blindsided by a new generation of blazing-fast racers, the legendary Lightning McQueen is suddenly pushed out of the sport he loves. To get back in the game, he will need the help of an eager young race technician with her own plan to win, inspiration from the late Fabulous Hudson Hornet, and a few unexpected turns. Proving that #95 isn't through yet will test the heart of a champion on Piston Cup Racing’s biggest stage!",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fyy1nDC8wm553FCiBDojkJmKLCs.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m09",
                "Mortal Kombat Legends: Scorpion’s Revenge",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg"
            )
        )

        movie.add(
            MovieEntity(
                "m10",
                "Frozen II",
                "Elsa, Anna, Kristoff and Olaf head far into the forest to learn the truth about an ancient mystery of their kingdom.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/h6Wi81XNXCjTAcdstiCLRykN3Pa.jpg"
            )
        )


        return movie
    }

    fun getDummyTv(): List<MovieEntity>{
         val tv = ArrayList<MovieEntity>()

        tv.add(
            MovieEntity(
                "t01",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t02",
                "Money Heist",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t03",
                "The Witcher",
                "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zrPpUlehQaBf8YX2NrVrKK8IEpf.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t04",
                "Vikings",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ff1zhqvwfS5HvRNcA5UFrH0PA2q.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t05",
                "The Seven Deadly Sins",
                "The “Seven Deadly Sins”—a group of evil knights who conspired to overthrow the kingdom of Britannia—were said to have been eradicated by the Holy Knights, although some claim that they still live. Ten years later, the Holy Knights have staged a Coup d'état and assassinated the king, becoming the new, tyrannical rulers of the kingdom. Elizabeth, the king's only daughter, sets out on a journey to find the “Seven Deadly Sins,” and to enlist their help in taking back the kingdom.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gxTojpKEOtue85EEFlozwRbDXwJ.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t06",
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t07",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t08",
                "Hunter x Hunter",
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/tolQj5yffSxkEGXusPwNcvYrbph.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t09",
                "Avatar: The Last Airbender",
                "In a war-torn world of elemental magic, a young boy reawakens to undertake a dangerous mystic quest to fulfill his destiny as the Avatar, and bring peace to the world.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/42nUsJrcD4Us4SbILeYi7juBVJh.jpg"
            )
        )

        tv.add(
            MovieEntity(
                "t10",
                "Sherlock",
                " modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aguWVR8xNilvw7t4X03UvG1hRJr.jpg"
            )
        )

        return tv
    }
}
