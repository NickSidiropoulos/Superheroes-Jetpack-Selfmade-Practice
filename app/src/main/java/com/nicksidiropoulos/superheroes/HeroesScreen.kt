package com.nicksidiropoulos.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicksidiropoulos.superheroes.model.Hero

@Composable
fun HeroList(cp: PaddingValues, heroes: List<Hero>){
    LazyColumn(
        contentPadding = cp,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
        ){
        items(heroes){
            HeroItem(hero = it, modifier = Modifier.padding(16.dp,8.dp,16.dp,8.dp))
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.large),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )

    ) {
        Row (
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Column(
                modifier = Modifier.weight(5f)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(
                modifier = Modifier
                    .weight(0.5f)
            )
            Box(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .weight(1.5f)
            ) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(id = hero.nameRes)
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemPreview(){
    HeroItem(Hero(R.string.hero1,R.string.description1,R.drawable.android_superhero1))
}
