package com.adwi.neumorph.sample.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adwi.neumorph.components.NeuButtonOval
import com.adwi.neumorph.components.NeuButtonRounded
import com.adwi.neumorph.components.NeuColorPicker
import com.adwi.neumorph.components.NeuPressed
import com.adwi.neumorph.components.NeuPunched
import com.adwi.neumorph.components.NeuRadioButton
import com.adwi.neumorph.components.NeuSliderBar
import com.adwi.neumorph.components.NeuSwitch
import com.adwi.neumorph.components.composables.NeuIcon
import com.adwi.neumorph.components.composables.picker.HsvColor
import com.adwi.neumorph.neumorph.LightSource
import com.adwi.neumorph.sample.ui.components.PreviewTemplate

@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var radioValue by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NeuRadioButton(
                value = radioValue,
                onValueChange = { radioValue = !radioValue },
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "Radio button",
                color = MaterialTheme.colors.onBackground
            )
        }
        var switchValue by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NeuSwitch(
                value = switchValue,
                onValueChange = { switchValue = !switchValue },
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "Switch",
                color = MaterialTheme.colors.onBackground
            )
        }
        NeuButtonRounded(
            elevation = 10.dp,
            cornerRadius = 10.dp,
            lightSource = LightSource.LEFT_TOP,
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .height(90.dp)
                .width(250.dp)
                .padding(bottom = 12.dp),
            content = {
                Text(
                    text = "Neumorph UI",
                    color = MaterialTheme.colors.onSurface
                )
            }
        )
        NeuButtonOval(
            elevation = 10.dp,
            backgroundColor = MaterialTheme.colors.surface,
            lightSource = LightSource.LEFT_TOP,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .size(70.dp),
            content = { NeuIcon() }
        )
        NeuPressed(
            elevation = 10.dp,
            cornerRadius = 10.dp,
            lightSource = LightSource.LEFT_TOP,
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier
                .height(100.dp),
            content = {
                Text(
                    text = "Neumorph UI",
                    color = MaterialTheme.colors.onSurface
                )
            }
        )
        NeuPunched(
            elevation = 10.dp,
            cornerRadius = 10.dp,
            lightSource = LightSource.LEFT_TOP,
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            content = {
                Text(
                    text = "Neumorph UI",
                    color = MaterialTheme.colors.onSurface
                )
            }
        )
        var sliderValue by remember { mutableStateOf(0.5f) }
        NeuSliderBar(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            elevation = 10.dp,
            lightSource = LightSource.LEFT_TOP,
            cornerRadius = 10.dp,
            handleColor = MaterialTheme.colors.primary,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        val colorValue = remember { mutableStateOf(Color.Red) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            NeuButtonOval(
                elevation = 10.dp,
                backgroundColor = colorValue.value,
                lightSource = LightSource.LEFT_TOP,
                modifier = Modifier.size(70.dp),
                content = { }
            )
            Spacer(modifier = Modifier.size(24.dp))
            NeuColorPicker(
                color = colorValue.value,
                onColorChanged = { hsvColor: HsvColor ->
                    colorValue.value = hsvColor.toColor()
                },
                elevation = 10.dp,
                cornerRadius = 10.dp,
                lightSource = LightSource.LEFT_TOP,
                handleColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray,
                modifier = Modifier.padding(12.dp)
            )
        }
        NeuPressed(
            elevation = 10.dp,
            cornerRadius = 10.dp,
            lightSource = LightSource.LEFT_TOP,
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier,
            content = {
                Text(
                    text =
                    "TextField \nBottom Nav \nApp bar \nPopup \nCircular progress indicator \nDial",
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
        )

        // Interactive Card Gallery
        Text(
            text = "Interactive Cards",
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            NeuPressed(
                elevation = 15.dp,
                cornerRadius = 20.dp,
                lightSource = LightSource.LEFT_TOP,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                content = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Card 1",
                            color = MaterialTheme.colors.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        NeuButtonOval(
                            elevation = 8.dp,
                            backgroundColor = MaterialTheme.colors.primary,
                            lightSource = LightSource.LEFT_TOP,
                            modifier = Modifier.size(40.dp),
                            content = { }
                        )
                    }
                }
            )
            NeuPunched(
                elevation = 15.dp,
                cornerRadius = 20.dp,
                lightSource = LightSource.RIGHT_BOTTOM,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier
                    .weight(1f)
                    .height(120.dp),
                content = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Card 2",
                            color = MaterialTheme.colors.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        NeuButtonOval(
                            elevation = 8.dp,
                            backgroundColor = MaterialTheme.colors.secondary,
                            lightSource = LightSource.RIGHT_BOTTOM,
                            modifier = Modifier.size(40.dp),
                            content = { }
                        )
                    }
                }
            )
        }

        // Music Player Interface
        Text(
            text = "Music Player",
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            NeuPressed(
                elevation = 15.dp,
                cornerRadius = 20.dp,
                lightSource = LightSource.LEFT_TOP,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.fillMaxSize(),
                content = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        // Simple album art
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .padding(bottom = 16.dp)
                        ) {
                            NeuPressed(
                                elevation = 8.dp,
                                cornerRadius = 12.dp,
                                lightSource = LightSource.LEFT_TOP,
                                backgroundColor = MaterialTheme.colors.primary,
                                modifier = Modifier.fillMaxSize(),
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Album Art",
                                        tint = Color.White,
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                            )
                        }
                        
                        // Song Info
                        Text(
                            text = "Song Title",
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = "Artist Name",
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                            style = MaterialTheme.typography.subtitle2
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Progress Bar
                        var progress by remember { mutableStateOf(0.3f) }
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            NeuSliderBar(
                                value = progress,
                                onValueChange = { progress = it },
                                elevation = 8.dp,
                                lightSource = LightSource.LEFT_TOP,
                                cornerRadius = 8.dp,
                                handleColor = MaterialTheme.colors.primary,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "1:23",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                                    style = MaterialTheme.typography.caption
                                )
                                Text(
                                    text = "3:45",
                                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                                    style = MaterialTheme.typography.caption
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Controls
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            NeuButtonOval(
                                elevation = 8.dp,
                                backgroundColor = MaterialTheme.colors.surface,
                                lightSource = LightSource.LEFT_TOP,
                                modifier = Modifier.size(48.dp),
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.SkipPrevious,
                                        contentDescription = "Previous",
                                        tint = MaterialTheme.colors.onSurface
                                    )
                                }
                            )
                            NeuButtonOval(
                                elevation = 12.dp,
                                backgroundColor = MaterialTheme.colors.primary,
                                lightSource = LightSource.LEFT_TOP,
                                modifier = Modifier.size(64.dp),
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        tint = Color.White
                                    )
                                }
                            )
                            NeuButtonOval(
                                elevation = 8.dp,
                                backgroundColor = MaterialTheme.colors.surface,
                                lightSource = LightSource.LEFT_TOP,
                                modifier = Modifier.size(48.dp),
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.SkipNext,
                                        contentDescription = "Next",
                                        tint = MaterialTheme.colors.onSurface
                                    )
                                }
                            )
                        }
                    }
                }
            )
        }

        // Animated Buttons Grid
        Text(
            text = "Animated Buttons",
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                NeuButtonRounded(
                    elevation = 10.dp,
                    cornerRadius = 12.dp,
                    lightSource = LightSource.LEFT_TOP,
                    backgroundColor = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    content = {
                        Text(
                            text = "Primary",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                )
                NeuButtonRounded(
                    elevation = 10.dp,
                    cornerRadius = 12.dp,
                    lightSource = LightSource.RIGHT_BOTTOM,
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    content = {
                        Text(
                            text = "Secondary",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                NeuButtonRounded(
                    elevation = 10.dp,
                    cornerRadius = 12.dp,
                    lightSource = LightSource.LEFT_BOTTOM,
                    backgroundColor = MaterialTheme.colors.error,
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    content = {
                        Text(
                            text = "Error",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                )
                NeuButtonRounded(
                    elevation = 10.dp,
                    cornerRadius = 12.dp,
                    lightSource = LightSource.RIGHT_TOP,
                    backgroundColor = MaterialTheme.colors.surface,
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    content = {
                        Text(
                            text = "Surface",
                            color = MaterialTheme.colors.onSurface,
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light")
@Composable
private fun HomePreviewLight() {
    PreviewTemplate(
        darkTheme = false,
    ) {
        HomeScreen()
    }
}

@Preview(showBackground = true, name = "Dark")
@Composable
private fun HomePreviewDark() {
    PreviewTemplate(
        darkTheme = true,
    ) {
        HomeScreen()
    }
}
