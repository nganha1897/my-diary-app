package com.ha.util.model

import androidx.compose.ui.graphics.Color
import com.ha.ui.theme.AngryColor
import com.ha.ui.theme.AwfulColor
import com.ha.ui.theme.BoredColor
import com.ha.ui.theme.CalmColor
import com.ha.ui.theme.DepressedColor
import com.ha.ui.theme.DisappointedColor
import com.ha.ui.theme.HappyColor
import com.ha.ui.theme.HumorousColor
import com.ha.ui.theme.LonelyColor
import com.ha.ui.theme.MysteriousColor
import com.ha.ui.theme.NeutralColor
import com.ha.ui.theme.RomanticColor
import com.ha.ui.theme.ShamefulColor
import com.ha.ui.theme.SurprisedColor
import com.ha.ui.theme.SuspiciousColor
import com.ha.ui.theme.TenseColor
import com.ha.util.R

enum class Mood(
    val icon: Int,
    val contentColor: Color,
    val containerColor: Color
) {
    Neutral(
        icon = R.drawable.neutral,
        contentColor = Color.Black,
        containerColor = NeutralColor
    ),
    Happy(
    icon = R.drawable.happy,
    contentColor = Color.Black,
    containerColor = HappyColor
    ),
    Angry(
    icon = R.drawable.angry,
    contentColor = Color.White,
    containerColor = AngryColor
    ),
    Bored(
    icon = R.drawable.bored,
    contentColor = Color.Black,
    containerColor = BoredColor
    ),
    Calm(
    icon = R.drawable.calm,
    contentColor = Color.Black,
    containerColor = CalmColor
    ),
    Depressed(
    icon = R.drawable.depressed,
    contentColor = Color.Black,
    containerColor = DepressedColor
    ),
    Disappointed(
    icon = R.drawable.disappointed,
    contentColor = Color.White,
    containerColor = DisappointedColor
    ),
    Humorous(
    icon = R.drawable.humorous,
    contentColor = Color.Black,
    containerColor = HumorousColor
    ),
    Lonely(
    icon = R.drawable.lonely,
    contentColor = Color.White,
    containerColor = LonelyColor
    ),
    Mysterious(
    icon = R.drawable.mysterious,
    contentColor = Color.Black,
    containerColor = MysteriousColor
    ),
    Romantic(
    icon = R.drawable.romantic,
    contentColor = Color.White,
    containerColor = RomanticColor
    ),
    Shameful(
    icon = R.drawable.shameful,
    contentColor = Color.White,
    containerColor = ShamefulColor
    ),
    Awful(
    icon = R.drawable.awful,
    contentColor = Color.Black,
    containerColor = AwfulColor
    ),
    Surprised(
    icon = R.drawable.surprised,
    contentColor = Color.Black,
    containerColor = SurprisedColor
    ),
    Suspicious(
    icon = R.drawable.suspicious,
    contentColor = Color.Black,
    containerColor = SuspiciousColor
    ),
    Tense(
    icon = R.drawable.tense,
    contentColor = Color.Black,
    containerColor = TenseColor
    )
}