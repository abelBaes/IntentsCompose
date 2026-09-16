package br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddWordScreen(actualText: String, modifier: Modifier, concatenateText: (String) -> Unit) {
    var textToConcatenate by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tela de Adicionar Palavras",
            Modifier.padding(5.dp),
            fontSize = 30.sp
        )
        Text(
            text = "Texto atual",
            Modifier.padding(5.dp),
            fontSize = 25.sp
        )
        Text(
            text = actualText,
            Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = textToConcatenate,
            onValueChange = { textToConcatenate = it },
            label = { Text("Texto à concatenar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Button(
            onClick = {concatenateText(textToConcatenate)}
        ) {
            Text(
                text = "Concatenar",
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun AddWordScreenPreview() {
    AddWordScreen(
        "SomeText",
        Modifier,
        {}
    )
}