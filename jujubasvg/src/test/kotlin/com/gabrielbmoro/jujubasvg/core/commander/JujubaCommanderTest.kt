package com.gabrielbmoro.jujubasvg.core.commander

import app.cash.turbine.test
import com.gabrielbmoro.jujubasvg.model.NodeCoordinate
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JujubaCommanderTest {

    @Test
    fun `given an update background color command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "updateBackgroundColor('12','#0000');"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(Command.UpdateBackgroundColor("12", "#0000"))

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given an update stroke color command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "updateStrokeColor('12','#0000');"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(Command.UpdateStrokeColor("12", "#0000"))

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given an update stroke width command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "updateStrokeWidth('12',45);"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(Command.UpdateStrokeWidth("12", 45))

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given a remove node command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "removeNode('12');"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(Command.RemoveNode("12"))

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given a change root background color command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "updateRootBackgroundColor('#000000');"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(Command.UpdateRootBackgroundColor("#000000"))

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given a addRoundedImage when element is rounded command when it is invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand =
                "addRoundedImage('elementId','imageId','imageUrl','45','48','0.0','1.0');"
            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(
                    Command.AddRoundedImage(
                        "elementId",
                        "imageId",
                        "imageUrl",
                        45,
                        48,
                        NodeCoordinate(
                            0f,
                            1f
                        )
                    )
                )

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }

    @Test
    fun `given the commands update background color and remove node when they are invoked then emit the right jsCommand`() =
        runTest {
            val jsCommand = "updateBackgroundColor('12','#0000');\nremoveNode('12');"

            val commander = JujubaCommander()

            commander.command.test {
                commander.execute(
                    Command.UpdateBackgroundColor("12", "#0000"),
                    Command.RemoveNode("12")
                )

                val result = awaitItem()
                assertEquals(jsCommand, result)
            }
        }
}