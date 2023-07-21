import DashboardLayout from "@/Layouts/DashboardLayout";
import { Head } from "@inertiajs/react";
import ok from "../assets/ok.svg";

export default function Dashboard({ auth, user }) {
    return (
        <div className="bg-[#EBDFD7] flex">
            <DashboardLayout user={auth.user} />
            <Head title="Dashboard"/>

            <div className="flex flex-col w-full">
                <div className="px-5 py-6 border-b-2 border-gray-300 max-h-[6rem] w-full">
                    <h1 className="text-3xl text-black font-medium ">
                        Dashboard
                    </h1>
                </div>
                <div className="mx-5 my-5 h-[4rem] flex items-center rounded-xl bg-white/40">
                    <h1 className="px-4 text-base inline-flex text-black">
                        You're logged in!
                        <img className="ml-1" src={ok} />
                    </h1>
                </div>
            </div>
        </div>
    );
}
