/*
 *  This file is part of the tock-bot-open-data distribution.
 *  (https://github.com/voyages-sncf-technologies/tock-bot-open-data)
 *  Copyright (c) 2017 VSCT.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Affero General Public License for more details.
 *
 *   You should have received a copy of the GNU Affero General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.vsct.tock.bot.open.data.story

import fr.vsct.tock.bot.connector.messenger.messengerPostback
import fr.vsct.tock.bot.connector.messenger.withMessengerButtons
import fr.vsct.tock.bot.definition.StoryHandlerBase
import fr.vsct.tock.bot.engine.BotBus
import fr.vsct.tock.bot.open.data.OpenDataStoryDefinition.departures
import fr.vsct.tock.bot.open.data.OpenDataStoryDefinition.search

/**
 *
 */
object GreetingsStoryHandler : StoryHandlerBase() {

    override fun action(bus: BotBus) {
        with(bus) {
            //cleanup state
            removeAllEntityValues()

            send("Bienvenue chez le Bot Open Data Sncf! :)")
            send("Il s'agit d'un bot de démonstration du framework Tock : https://github.com/voyages-sncf-technologies/tock", breath)
            withMessengerButtons(
                    "Il est volontairement très limité, mais demandez lui un itinéraire ou les départs à partir d'une gare et constatez le résultat! :) ",
                    messengerPostback("Itinéraire", search),
                    messengerPostback("Départs", departures))
            end(breath)
        }
    }
}