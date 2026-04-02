package com.cwg.mod.config

import com.google.gson.GsonBuilder

class CobblemonWikiGuiLang {

    companion object {
        val GSON = GsonBuilder()
        .disableHtmlEscaping()
        .setPrettyPrinting()
        .create()

        fun fromMap(map: Map<String, String>): CobblemonWikiGuiLang {
            val config = CobblemonWikiGuiLang()
            for ((key, value) in map) {
                try {
                    val field = config.javaClass.getDeclaredField(key)
                    field.isAccessible = true
                    field.set(config, value)
                } catch (e: NoSuchFieldException) {
                    System.err.println("Campo '$key' não encontrado em CobblemonWikiGuiLang.")
                } catch (e: IllegalAccessException) {
                    System.err.println("Não foi possível acessar o campo '$key': ${e.message}")
                }
            }
            return config
        }
    }

    var useItem: String = "Используйте %s"
    var tradeAny: String = "Совершите любой обмен или используйте %s"
    var tradeSpecific: String = "Обменяйте на %s или используйте %s"
    var level: String = "Уровень: %s"
    var friendship: String = "Дружба: %s"
    var heldItem: String = "Удерживаемый предмет: %s"
    var anyRequirement: String = "Нужно выполнить одно из требований:"
    var attackDefenceRatioAttackHigher: String = "Атака должна быть выше защиты"
    var attackDefenceRatioDefenceHigher: String = "Защита должна быть выше атаки"
    var attackDefenceRatioEqual: String = "Атака и защита должны быть равны"
    var blocksTraveled: String = "Нужно пройти блоков: %s"
    var defeat: String = "Нужно побед: %s"
    var moveSet: String = "Нужен приём: %s"
    var moveType: String = "Нужен любой приём типа %s"
    var recoil: String = "Нужен откат: %s"
    var statEqual: String = "Характеристики %s и %s должны быть равны"
    var statCompare: String = "%s должно быть выше, чем %s"
    var timeRange: String = "Время суток: %s"
    var useMove: String = "Нужно использовать приём %s (%s раз)"
    var biomeCondition: String = "Нужен тег биома: %s"
    var biomeAntiCondition: String = "Запрещённый тег биома: %s"
    var structureCondition: String = "Нужна структура: %s"
    var structureAntiCondition: String = "Запрещённая структура: %s"

    var noEvolutionFound: String = "Эволюции для %s не найдены"
    var rightClick: String = "Нажмите ПКМ по %s"
    var goBackClick: String = "Нажмите, чтобы вернуться"
    var seeEvolutions : String = "Нажмите, чтобы посмотреть эволюции"

    var seeCondtions : String = "Нажмите, чтобы посмотреть условия спавна"
    var noSpawnConditionFound: String = "Условия спавна для %s не найдены"

    var basestats: String = "Базовые характеристики"
    var type: String = "Тип"
    var effectiveness : String = "Эффективность"
    var catchrate : String = "Шанс поимки"
    var spawnbiome : String = "Биомы спавна"
    var spawntime : String = "Время спавна"
    var evolutions : String = "Эволюции"
    var movesbylevel : String = "Приёмы по уровню"
    var tmMoves : String = "TM-приёмы"
    var tutorMoves : String = "Приёмы наставника"
    var evolutionMoves : String = "Приёмы эволюции"
    var eggMoves : String = "Яичные приёмы"
    var formChangeMoves : String = "Приёмы смены формы"
    var abilities : String = "Способности"
    var evYield : String = "EV при победе"
    var drops : String = "Дроп"
    var eggGroups : String = "Яичные группы"
    var forms : String = "Формы"
    var dynamax : String = "Динамакс"
    var baseFriendship: String = "Дружба"
    var weakness : String = "Слабости:"
    var resistant : String = "Сопротивления:"
    var immune : String = "Иммунитеты:"
    var pokeInfo : String = "Нажмите для подробной информации"

    var noDrops: String = "Дроп отсутствует"
    var yes: String = "Да"
    var no: String = "Нет"
    var spawnConditionsTitle: String = "Условия спавна"
    var evolutionsTitle: String = "Эволюции"
    var currentPage: String = "Страница %s/%s"
    var conditionsLabel: String = "Условия:"
    var antiConditionsLabel: String = "Анти-условия:"
    var timeLabel: String = "Время:"
    var noRequirements: String = "Без требований"


    fun toMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        this.javaClass.declaredFields.forEach { field ->
            if (!java.lang.reflect.Modifier.isStatic(field.modifiers)) {
                field.isAccessible = true
                map[field.name] = field.get(this)?.toString() ?: ""
            }
        }
        return map
    }
}
