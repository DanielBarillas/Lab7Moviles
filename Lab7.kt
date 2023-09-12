import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource

data class Douglas(val name: String, val image: Int)

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val PersonajeList = listOf(
            Personaje("Douglas", R.drawable.douglas),
            Personaje("personaje", R.drawable.),
            Personaje("personaje2", R.drawable.),
            // Agrega más Personajes aqui, no me se todos Sorry :,(
            // Agregar los personajes faltantes que no me los seeee, ni tengo fotos asi qeu pongalos porfa
        )

        setContent {
            var searchText by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopAppBar(
                    title = { Text("Pokédex Game of Douglas") },
                    modifier = Modifier.fillMaxWidth()
                )

                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Buscar Personaje") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                // si agregan mas personajes agregarlo aqui
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(pokemonList.filter { it.name.contains(searchText, ignoreCase = true) }) { personaje ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            backgroundColor = Color.Gray,
                            elevation = 8.dp
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .background(MaterialTheme.colorScheme.surface)
                            ) {
                                Text(
                                    text = pokemon.name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Image(
                                    painter = painterResource(id = pokemon.image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonajeList() {
    val personajeList = listOf(
        Personaje("Douglas", R.drawable.),
        Personaje(" ", R.drawable.),
        Personaje(" ", R.drawable.),
        // copien la list de arriva y peguenla aqui 
    )

    Column {
        // Agrega otros componentes de vista previa aquí si es necesario.
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(pokemonList) { pokemon ->
                // Agrega la vista previa del Personaje aquí
            }
        }
    }
}
