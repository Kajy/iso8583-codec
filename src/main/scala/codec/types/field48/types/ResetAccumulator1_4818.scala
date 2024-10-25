package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class ResetAccumulator1_4818(toReset: Boolean) extends PrivateData48XX

object ResetAccumulator1_4818 {

  val codec: Codec[ResetAccumulator1_4818] =
    LLVAR_N
      .xmap(_ == "00", (b: Boolean) => if (b) "00" else "01")
      .as[ResetAccumulator1_4818]

}
