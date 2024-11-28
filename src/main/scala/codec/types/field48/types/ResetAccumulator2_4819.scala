package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{Codec, TransformSyntax}

case class ResetAccumulator2_4819(toReset: Boolean) extends PrivateData48XX

object ResetAccumulator2_4819 {

  val codec: Codec[ResetAccumulator2_4819] =
    LLVAR_N
      .xmap(_ == "00", (b: Boolean) => if (b) "00" else "01")
      .as[ResetAccumulator2_4819]

}
