package kr.pe.upj53.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.pe.upj53.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MyJetpackComposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					CreateBizCard()
				}
			}
		}
	}
}

@Composable
fun CreateBizCard() {
	val buttonClickedState = remember {
		mutableStateOf(false)
	}
	Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
		Card(
			modifier = Modifier
				.width(200.dp)
				.padding(12.dp)
				.height(390.dp),
			elevation = 4.dp,
			shape = RoundedCornerShape(corner = CornerSize(15.dp))
		) {
			Column(
				modifier = Modifier.height(300.dp),
				verticalArrangement = Arrangement.Top,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				CreateImageProfile()
				Divider()
				CreateInfo()
				Button(onClick = {
					buttonClickedState.value = !buttonClickedState.value
				}) {
					Text(
						"나의 포트폴리오",
						style = MaterialTheme.typography.button
					)
				}
				if (buttonClickedState.value) {
					Content()
				} else {
					Box {}
				}
			}
		}
	}
}

//@Preview
@Composable
fun Content() {
	Box(
		modifier = Modifier
			.fillMaxHeight()
			.fillMaxWidth()
			.padding(5.dp)
	) {
		Surface(
			modifier = Modifier.padding(3.dp)
				.fillMaxWidth()
				.fillMaxHeight(),
			shape = RoundedCornerShape(corner = CornerSize(6.dp)),
			border = BorderStroke(width = 2.dp, color = Color.LightGray)
		) {
			Portfolio(data = listOf(
				"프로젝트 A3", "프로젝트 B1", "프로젝트 C2",
				"프로젝트 D7", "프로젝트 E9", "프로젝트 F14", "프로젝트 G4"
			))
		}
	}
}

@Composable
fun Portfolio(data: List<String>) {
	LazyColumn {
		items(data) { item ->
			Card(
				modifier = Modifier
					.padding(13.dp)
					.fillMaxWidth(),
				shape = RectangleShape,
				elevation = 4.dp,
			) {
				Row(
					modifier = Modifier
						.padding(16.dp)
						.background(MaterialTheme.colors.surface)
				) {
					CreateImageProfile(modifier = Modifier.size(70.dp))
					Column(
						modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)
					) {
						Text(text = item, fontWeight = FontWeight.Bold)
						Text(
							text = "Awesome Project",
							style = MaterialTheme.typography.body2
						)
					}
				}
			}
		}
	}
}

@Composable
private fun CreateInfo() {
	Column(
		modifier = Modifier
			.padding(5.dp)
	) {
		Text(
			text = "래리 페이지",
			style = MaterialTheme.typography.h4,
			color = MaterialTheme.colors.primaryVariant
		)
		Text(
			text = "Mobile Software Engineer",
			modifier = Modifier.padding(3.dp)
		)
		Text(
			text = "larry.page@google.com",
			modifier = Modifier.padding(3.dp),
			style = MaterialTheme.typography.subtitle1
		)
	}
}

@Composable
fun CreateImageProfile(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier.size(150.dp),
		shape = CircleShape,
		border = BorderStroke(0.5.dp, Color.LightGray),
		elevation = 4.dp,
		color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
	) {
		Image(
			painter = painterResource(id = R.drawable.profile_image),
			contentDescription = "profile image",
			modifier = modifier.size(150.dp),
			contentScale = ContentScale.Crop,
			alignment = Alignment.Center,
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	MyJetpackComposeTheme {
		CreateBizCard()
	}
}