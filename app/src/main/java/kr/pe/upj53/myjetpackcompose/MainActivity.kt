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
import androidx.compose.ui.text.style.TextDirection.Companion.Content
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
	// code here

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
					// code here

				}) {
				// code here

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
		// code here

	}
}

@Composable
fun Portfolio(data: List<String>) {
	LazyColumn {
		// code here
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