package codec

import scodec.bits.{BitVector, ByteVector}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

import java.time.format.DateTimeFormatter
import scala.math.max

object FieldCodecs {

  val yearMonthFormatter = DateTimeFormatter.ofPattern("yyMM")
  val localTimeFormatter = DateTimeFormatter.ofPattern("HHmmss")
  val localDateFormatter = DateTimeFormatter.ofPattern("MMdd")

  val quartet: Codec[Int] = int8.xmap(s => max(s / 2, 1), _ * 2)

  val N: Codec[String] = bits.xmap(
    _.toBase16,
    BitVector.fromValidHex(_)
  )

  val AN: Codec[String] = bytes.xmap(
    e => new String(e.toArray, "Cp1047"),
    d => ByteVector(d.getBytes("Cp1047"))
  )

  val ANS: Codec[String] = bytes.xmap(
    e => new String(e.toArray, "Cp1047"),
    d => ByteVector(d.getBytes("Cp1047"))
  )

  val LLVAR_N: Codec[String]   = variableSizeBytes(quartet, N)
  val LLVAR_AN: Codec[String]  = variableSizeBytes(int8, AN)
  val LLVAR_HEX: Codec[ByteVector] = variableSizeBytes(int8, bytes)
  val LLLVAR_AN: Codec[String] = variableSizeBytes(int16, AN)
  val LLVAR_ANS: Codec[String] = variableSizeBytes(int8, ANS)

  def AN(size: Long): Codec[String]  = fixedSizeBytes(size, AN)
  def ANS(size: Long): Codec[String] = fixedSizeBytes(size, AN)
  def N(size: Long): Codec[String]   = fixedSizeBits(size * 4, N) // Unit quartet

  def AN_INT(size: Long): Codec[Int] =
    AN(size).xmap(Integer.parseInt, _.toString)

  def TLV_N(size: Int): Codec[Long] = int8.consume(pbcd)(_ => size)

  def TLV[A, B](
      tagCodec: Codec[A],
      lengthCodec: Codec[Int],
      valueCodec: Codec[B]
  ): Codec[(A, B)] =
    tagCodec
      .flatZip(_ => variableSizeBytes(lengthCodec, valueCodec))
      .as[(A, B)]

  def LLVAR[A](codec: Codec[A]): Codec[A]   = variableSizeBytes(int8, codec)
  def LLVAR_N[A](codec: Codec[A]): Codec[A] = variableSizeBytes(quartet, codec)
  def LLLVAR[A](codec: Codec[A]): Codec[A]  = variableSizeBytes(int16, codec)
}
