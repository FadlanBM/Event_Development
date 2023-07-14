import { Link, router } from "@inertiajs/react";
import Ornament from "../assets/Ornament.svg";
import home from "../assets/home.png";

export default function Home() {
    return (
        <div className="flex py-[10rem] px-[12rem] xl:px-[15rem]">
            <div>
                <h1 className="xl:text-[6rem] leading-[6rem] font-semibold text-[5.1rem]">
                    Reliable, secure
                    <img className="inline align-top" src={Ornament} />
                    <br />
                    conference to get
                    <br />
                    the best events
                </h1>
                <p className="text-[#57585D] mt-[2rem] text-[20px]">
                    Hold incredible events, share knowledge, build and grow
                    your,
                    <br />
                    product , create opportunity
                </p>
                <Link href="/join">
                    <button className="w-[198px] h-[50px] mt-9 text-white font-medium rounded-md bg-[#E14817]">Join A Meeting</button>
                </Link>
            </div>

            <div>
                <img className="ml-[2.6rem]" src={home} />
            </div>
        </div>
    );
}
