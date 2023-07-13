import DashboardLayout from '@/Layouts/DashboardLayout';
import { Head } from "@inertiajs/react";

export default function Dashboard({ auth }) {
    
    return (
        <DashboardLayout
            user={auth.user}
            header={
                <h2 className="font-semibold text-xl w-full text-black">
                    Dashboard
                </h2>
            }
        >
            <Head title="Dashboard" />

            <div className="pt-10 pl-10">
                <div className="bg-white rounded-md">
                    <h1>kntl</h1>

                </div>
            </div>
            
        </DashboardLayout>
    );
}
